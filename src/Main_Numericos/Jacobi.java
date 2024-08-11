/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Numericos;

/**
 *
 * @author Benjamin
 */
public class Jacobi{

    
    public String metodoJacobi (double[][]arreglo,double[]resultados,double[]x,double tolerancia,int decimales)  {

        String consola="";
        int tam= resultados.length;

        EvaluarX EX=new EvaluarX();
        Redondeo R= new Redondeo();
double xn[]= new double [tam];

        for ( int i =0 ; i< tam ; i ++ )  {
            //System.out.print("X"+i+"\t");
            consola+="X"+i+"\t";

        } 

      //  System.out.print("error");
consola+="error\n";
    
        //System.out.print("\n");
        for ( int i =0 ; i< tam ; i ++ )  {
            x[i]=1;
            //System.out.print(x[i]+"\t");
            consola+=x[i]+"\t";
        } consola+="\n";//System.out.print("\n");

        // double tolerancia=0.0001;
        double error=tolerancia+ 1;
        //int decimales=4;
        String funcion="";
        EvaluadorFunciones EF= new EvaluadorFunciones();

        for ( int i =0 ; i< tam ; i ++ )  {
            funcion+="("+resultados[i];
            for ( int j =0 ; j< tam ; j ++ )  {if(j!=i)funcion += "-("+ arreglo[i][j]+"*"+x[j]+")"; }

            funcion +=")/"+arreglo[i][i];
            error=x[i];
            xn[i]= R.redondear((EF.eval(funcion)),decimales);
            error=R.redondear(Math.abs(error-xn[i]),decimales);

            //System.out.print(x[i]+"\t");
            consola+=xn[i]+"\t";
            funcion="";
        }
         for ( int i =0 ; i< tam ; i ++ )  {x[i]=xn[i];}
        //System.out.print(R.redondear(error,decimales)+"\n");
        consola+=R.redondear(error,decimales)+"\n";

        while (error>tolerancia){
            for ( int i =0 ; i< tam ; i ++ )  {
                funcion+="("+resultados[i];
                for ( int j =0 ; j< tam ; j ++ )  {if(j!=i)funcion += "-("+ arreglo[i][j]+"*"+x[j]+")"; }

                funcion +=")/"+arreglo[i][i];
                error=x[i];
                xn[i]= R.redondear((EF.eval(funcion)),decimales);
                error=Math.abs(error-xn[i]);

                
                //System.out.print(x[i]+"\t");
               consola+=xn[i]+"\t";
                funcion="";
            }
             for ( int i =0 ; i< tam ; i ++ )  {x[i]=xn[i];}
          //  System.out.print(R.redondear(error,decimales)+"\n");
consola+=R.redondear(error,decimales)+"\n";
        }

        return consola;
    }
    
    
    
    // public static void main(String []args) {

        
        // Jacobi J = new Jacobi () ; 

        // double arreglo[][] = new double [3][3];
        // arreglo[0][0]=8.0;
        // arreglo[0][1]=2.0;
        // arreglo[0][2]=3.0;
        // arreglo[1][0]=1.0;
        // arreglo[1][1]=-9.0;
        // arreglo[1][2]=2.0;
        // arreglo[2][0]=2.0;
        // arreglo[2][1]=3.0;
        // arreglo[2][2]=6.0;

        
        // double resultados[] = new double [3];
        // resultados[0]= 30;
        // resultados[1]= 1;
        // resultados[2] = 31;

        // double x [] = new double [3];
        // for ( int i =0 ; i< 3 ; i ++ )  {
            // x[i]=1;
        // } 
        // System.out.println(J.metodoJacobi(arreglo,resultados,x,0.0001,4));


    // }
}
