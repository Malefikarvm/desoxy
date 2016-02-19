package Components.Uroboros;

/**
 * Created by Analista on 09/02/2016.
 */
class Disk<Obj> {

    private Disk left;
    private Obj id;
    private Obj val;
    private Disk right;

    public Disk(){
        id = val = null;
        right = left = null;
    }

    //SET METHODS

    /**
     * Links the left node
     * @param l
     */
    public void setLeft(Disk l){ left = l; }

    /**
     * Set the id of the actual node as associative or indexed for go through the list
     * @param id
     */
    public void setId(Obj id){ this.id = id; }

    /**
     * Set the value of the actual node
     * @param v
     */
    public void setVal(Obj v){ val = v; }

    /**
     * Links the right node
     * @param r
     */
    public void setRight(Disk r){ right = r; }

    //GET METHODS

    /**
     * Obtains the left node
     * @return
     */
    public Disk getLeft(){ return left; }

    /**
     * Obtains the associatiive or indexed value of the node
     * @return
     */
    public Obj getId(){ return id; }

    /**
     * Obtains the value of actual node
     * @return
     */
    public Obj getVal(){ return val; }

    /**
     * Obtains the left node
     * @return
     */
    public Disk getRight(){ return right; }


}

