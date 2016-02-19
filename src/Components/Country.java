package Components;

import java.util.Hashtable;

/**
 * Created by Analista on 10/10/2015.
 */
public class Country {

    public Country(){
        relationMXC();
    }

    private static final int colombia = 127;
    private static final int venezuela = 36;
    private static final int panama = 6;
    private static final int guatemala = 6;
    private static final int salvador  = 70;
    private static final int honduras = 6;
    private static final int nicaragua = 6;
    private static final int costarica = 6;
    private static final int ecuador = 14;

    private Hashtable<String, Hashtable> moduleXcountry = new Hashtable();
    public static final String[] moduleX = new String[]{"Plano de campo", "Detallado de Exhibiciones",
            "Extravisibilidad", "Banco de Imagenes", "One Pager", "Draft", "Recambios"};
    public static final String[] xCountry = new String[]{"Colombia", "Venezuela", "Panama",
            "Guatemala", "Salvador", "Honduras", "Nicaragua", "Costa Rica", "Ecuador"};

    public int getCountry(String country){
        switch (country.trim().toLowerCase()){
            case "colombia":
                return colombia;
            case "venezuela":
                return venezuela;
            case "panama":
                return panama;
            case "guatemala":
                return guatemala;
            case "salvador":
                return salvador;
            case "honduras":
                return honduras;
            case "nicaragua":
                return nicaragua;
            case "costarica":
                return costarica;
            case "ecuador":
                return ecuador;
            default:
                return 0;
        }
    }

    public int[] getModuleMark(String country){
        int[] response = new int[moduleX.length];
        int decimal = getCountry(country);
        int result = decimal;
        for(int i=moduleX.length-1; i>=0; i--){
            int binary = result % 2;
            response[i] = binary;
            result = result / 2;
        }
        return response;
    }

    private void relationMXC(){
        for(int i=0; i<moduleX.length; i++){
            Hashtable<String, String> country = new Hashtable();
            for(int j=0; j<xCountry.length; j++){
                int  mark = getModuleMark(xCountry[j])[i];
                if(mark==0){
                    country.put(xCountry[j], "NO");
                }else if(mark==1){
                    country.put(xCountry[j], "SI");
                }
            }
            moduleXcountry.put(moduleX[i], country);
        }
    }

    public boolean applyingModule(String mdl, String cntry){
        boolean validate = false;
        for (int i=0; i<moduleXcountry.size(); i++){
            Hashtable data = moduleXcountry.get(moduleX[i]);
            if (moduleX[i].trim().toLowerCase().equals(mdl.trim().toLowerCase())) {
                for(int j=0; j<xCountry.length; j++){
                    if(xCountry[j].trim().toLowerCase().equals(cntry.trim().toLowerCase())){
                        System.out.println(moduleX[i]+"{"+xCountry[j]+"->"+data.get(xCountry[j])+"}");
                        validate = data.get(xCountry[j]).equals("SI") ? true : false;
                    }
                }
            }
        }
        return validate;
    }

    public Hashtable getRelation(){
        return moduleXcountry;
    }

}
