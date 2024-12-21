package upnadirect147157;

import java.time.LocalDate;


/**
 *
 * @author alumno
 */
public class Mafro implements Aseguradora{
    private TecnicoComercial tecnico;
    double oferta;

    public Mafro(TecnicoComercial tecnico){
        this.tecnico = tecnico;
    }

    
    @Override
    public double calcularOferta(){
        
        Bien bien;
        Cliente cliente;
        bien = tecnico.getBien();
        cliente = tecnico.getCliente();
        if(bien.getTipo().equals("vehiculo") && (cliente.getAnioNacimiento() - LocalDate.now().getYear() < 20)){
            oferta = 0.05 * bien.getValor();
        }
        else if(bien.getTipo().equals("vivienda") && (bien.getValor() > 200000) && (cliente.getSalario() < 20000)){
            oferta = 0.02 * bien.getValor();
        }
        else{
            oferta = 0.03 * bien.getValor()
                    ; 
        }

        return oferta;
    }

    @Override
    public int calcularComisison(){
        int comision;
        if(oferta < 1000){
            comision = (int) Math.floor(0.01 * oferta);
        }
        else {
            comision = (int) Math.floor(0.03 * oferta);
        }
        return comision;
    }
}
