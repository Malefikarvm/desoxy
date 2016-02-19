package Components.Uroboros;

/**
 * Created by Analista on 09/02/2016.
 */
class Spine<Obj> extends Disk<Obj> {

    private Disk disk;
    private Disk first;
    private Disk last;
    private Disk head;
    private int index = 0;

    public Spine(String name){
        disk = new Disk();
        disk.setId(null);
        disk.setVal(null);
        disk.setLeft(head);
        disk.setRight(head);
        first=last=disk;
        head = new Disk<String>();
        head.setId("head");
        head.setVal(name);
        head.setLeft(last);
        head.setRight(first);
    }

    public void uAdd(Obj... value){
        Disk n = new Disk();
        if(value.length>1){
            n.setId(Index(value[0]));
        }else{
            n.setId(this.index);
        }
        increaseIndex();
        increaseIndex();
        n.setVal(value[1]);
        if(uIsEmpty()){
            n.setLeft(head);
            n.setRight(head);
            head.setLeft(n);
            head.setRight(n);
            first=last=n;
        }else{
            n.setLeft(head);
            n.setRight(last);
            last.setLeft(n);
            head.setLeft(n);
            last=n;
        }
    }

    private void increaseIndex(){
        index++;
    }

    private Object Index(Obj val){
        return typeOf(val).equals("String") ? val : (val == null ? index : null);
    }

    private boolean uIsEmpty(){
        boolean uIsE;
        try{
            uIsE = (first==last) && (last.getVal()==null) ? true : false;
        }catch(NullPointerException e){
            return true;
        }
        return uIsE;
    }

    public void uGoThrough() {
        if(!uIsEmpty()){
            Disk pointer;
            pointer = first;
            System.out.println(uName());
            while(pointer.getVal()!=head.getVal()){
                System.out.println(pointer.getId()+"=>"+pointer.getVal());
                pointer = pointer.getLeft();
            }
        }else{
            System.out.println("No hay datos que mostrar");
        }
    }

    public String uName() {
        return head.getVal().toString();
    }

    public Obj uFirstElement(){
        return (Obj) first.getVal();
    }

    public Obj uAt(Obj position){
        Obj value = null;
        if(!uIsEmpty()){
            Disk pointer;
            pointer = first;
            System.out.println(uName());
            while(pointer.getVal()!=head.getVal()){
                if(pointer.getId() == position ){
                    value = (Obj) pointer.getVal();
                }
                pointer = pointer.getLeft();
            }
        }else{
            System.out.println("No hay datos que mostrar");
        }
        return value;
    }

    public String typeOf(Obj val) {

        String valueOf = "";
        if(val instanceof Integer){
            valueOf =  "Integer";
        }else if(val instanceof Float){
            valueOf =  "Float";
        }else if(val instanceof Double){
            valueOf =  "Double";
        }else if(val instanceof Character){
            valueOf =  "Character";
        }else if(val instanceof Boolean){
            valueOf =  "Boolean";
        }else if(val instanceof Short){
            valueOf =  "Short";
        }else if(val instanceof Long){
            valueOf =  "Long";
        }else if(val instanceof Byte){
            valueOf =  "Byte";
        }else if(val instanceof String){
            valueOf =  "String";
        }else{
            valueOf =  val.getClass().toString();
        }

        return valueOf;
    }

}
