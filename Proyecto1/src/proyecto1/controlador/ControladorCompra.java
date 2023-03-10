package proyecto1.controlador;

import java.awt.Desktop;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.util.ArrayList;
import java.util.Random;
import org.apache.pdfbox.pdmodel.font.PDFont;
import proyecto1.modelo.Compras;

/**
 *
 * @author JD
 */
public class ControladorCompra {
    
    static ArrayList<Compras> arrayCompra = new ArrayList<>();
    static ArrayList<Compras> arrayCompraUsuario = new ArrayList<>();
    ControladorRegion controladorR = new ControladorRegion();
    ControladorDepartamento controladorD = new ControladorDepartamento();
    ControladorUsuario usuario = new ControladorUsuario();
    
    String path;
    String totalPDF;
    
    public String Cotizar(String depaO, String muniO, String direccionO, String deparD, String muniD, String direccionD, String cantidad, String peso, String tipoRegion) {
        double total = 0;
        double precioRegion = 0;
        int tamanioP = 0;
        int numeroP = Integer.parseInt(cantidad);
        
        if(tipoRegion.equalsIgnoreCase("estándar")) {
            precioRegion = controladorR.ObtenerRegionSeleccionada(controladorD.ObtenerDepartamentoNombre(deparD).getCodigoRegion()).getEstandar();
        } else if(tipoRegion.equalsIgnoreCase("especial")) {
            precioRegion = controladorR.ObtenerRegionSeleccionada(controladorD.ObtenerDepartamentoNombre(deparD).getCodigoRegion()).getEspecial();
        }
        
        if(peso.equalsIgnoreCase("pequeño")) {
            tamanioP = 15;
        } else if(peso.equalsIgnoreCase("mediano")) {
            tamanioP = 25;
        } else if(peso.equalsIgnoreCase("grande")) {
            tamanioP = 35;
        }
        
        total = precioRegion*tamanioP*numeroP;
        totalPDF =  String.valueOf((double)Math.round(total*100d)/100d);
        return String.valueOf((double)Math.round(total*100d)/100d);
    }
    
    public void RealizarCompra(String depaO, String muniO, String direccionO, String deparD, String muniD, String direccionD, String cantidad, String peso, String tipoPago, String numeroT, String tipoRegion, String datosF) {
        double totalC = Double.parseDouble(Cotizar( depaO,  muniO,  direccionO,  deparD,  muniD,  direccionD,  cantidad,  peso,  tipoRegion));
        if(tipoPago.equalsIgnoreCase("Contra entrega")) {
            totalC = totalC +5;
            arrayCompra.add(new Compras(depaO, muniO, direccionO, deparD, muniD, direccionD, "IPC1D"+CodigoPaquete(), tipoRegion, cantidad, peso, tipoPago, datosF, String.valueOf(totalC), usuario.UsuarioLogeado().getCorreo() ));
            
        } else if (tipoPago.equalsIgnoreCase("con tarjeta")) {
            arrayCompra.add(new Compras(depaO, muniO, direccionO, deparD, muniD, direccionD, "IPC1D"+CodigoPaquete(), tipoRegion, cantidad, peso, tipoPago,numeroT, datosF, String.valueOf(totalC), usuario.UsuarioLogeado().getCorreo() ));
        }
        
    }
    
    public String CodigoPaquete() {
        Random r = new Random();
        boolean flag = true;
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";
        char[] code = new char[5];
        do{
            for(int i = 0; i < code.length; i++) {
                code[i] = alphabet.charAt(r.nextInt(alphabet.length()));
            }
        
            if(ValidarCodigo(String.valueOf(code))) {
                flag = false;
            }
        } while(flag == false);

        return String.valueOf(code);
    }
    
    public boolean ValidarCodigo(String code) {
        for(Compras c: arrayCompra) {
            if(c.getIdPaquete().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
    
    public void GuardarComprasUsuario() {
        LimpiarArray();
        for(Compras c: arrayCompra) {
            if(c.getUsuario().equals(usuario.UsuarioLogeado().getCorreo())) {
                arrayCompraUsuario.add(new Compras(c.getDepartamentoO(),c.getMuicipioO(),c.getDepartamentoO(), c.getDepartamentoD(), c.getMunicipioD(), c.getDireccionD(), c.getIdPaquete(), c.getTipoServicio(),c.getNumeroP(),c.getPesoP(), c.getTipoPago(),c.getNumeroTarjeta(), c.getDatosFacturacion(),c.getTotal(), c.getUsuario()));
            }
        }
    }
    
    public ArrayList<Compras> ObtenerComprasUsuario() {
        return arrayCompraUsuario;
    }
    
    public void LimpiarArray() {
        arrayCompraUsuario.clear();
    }
    
    public void DescargarCotizacion(String deparO, String muniO, String deparD, String muniD, String tamanio, String cantidad, String servicio  ) {
        try(PDDocument documento = new PDDocument()) {
            
            path = "Cotizacion_"+CodigoPaquete()+usuario.UsuarioLogeado().getNombre()+".pdf";
            
             //CREA UN DOCUMENTO
            PDPage pagina = new PDPage(PDRectangle.LETTER); // CREA UNA PAGINA
            documento.addPage(pagina); // AGREGAMOS LA PAGINA
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina); // EL CONTENIDO
            PDFont font = PDType1Font.HELVETICA_BOLD;
            
            int paginaWidth = (int) pagina.getTrimBox().getWidth();
            int paginaHeight = (int) pagina.getTrimBox().getHeight();
            
            PDImageXObject image = PDImageXObject.createFromFile("src/img/U-delivery.png", documento);
            
            contenido.drawImage(image, 120, paginaHeight-206, 389,191);
            
            PDImageXObject imageP = PDImageXObject.createFromFile("src/img/U-delivery.png", documento);
            
            contenido.drawImage(imageP, 220, 60, 189,91);
            
            contenido.beginText();
            contenido.setFont(font, 30);
            String titulo = "COTIZACIÓN";
            float tituloA = font.getStringWidth(titulo) / 1000 * 30;
            contenido.newLineAtOffset((paginaWidth-tituloA)/2,paginaHeight-266);
            contenido.showText(titulo);
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            contenido.newLineAtOffset(50,paginaHeight-306);
            contenido.showText("NOMBRE: "+usuario.UsuarioLogeado().getNombre()+" "+usuario.UsuarioLogeado().getApellido());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            contenido.newLineAtOffset(50,paginaHeight-326);
            contenido.showText("CORREO: "+usuario.UsuarioLogeado().getCorreo());
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            contenido.newLineAtOffset(50,paginaHeight-356);
            contenido.showText("En atención a su solicitud, nos permitimos cotizar lo siguiente:");
            contenido.endText();
            
            // TABLA
            int initXA = 30;
            int initXB = 30;
            int initXC = 30;
            int initYA= paginaHeight-386;
            int initYB = paginaHeight-406;
            int initYC = paginaHeight-426;
            int cellHeight = 20;
            int cellWidthA= 160;
            int cellWidthB = 80;
            
            int colCont = 7;
            
            String[] datos = {deparO, muniO, deparD, muniD, tamanio, cantidad, servicio};
            
            String[] columnasA = {"ORIGEN", "DESTINO"};
            String[] columnasB = {"DEPARTAMENTO","MUNICIPIO","DEPARTAMENTO","MUNICIPIO","TAMAÑO","CANTIDAD","SERVICIO"};
            
            //for(int i = 1; i <= rowCont; i++) {
            for(int i = 1; i<= 2; i++) {
                contenido.addRect(initXA, initYA, cellWidthA, -cellHeight);
                contenido.beginText();
                contenido.newLineAtOffset(initXA+40, initYA-cellHeight+5);
                contenido.setFont(font, 15);
                contenido.showText(columnasA[i-1]);
                contenido.endText();
                initXA+=cellWidthA;
            }
            
            for(int j = 1; j <= colCont; j++) {
                contenido.addRect(initXB, initYB, cellWidthB, -cellHeight);
                    
                contenido.beginText();
                contenido.newLineAtOffset(initXB+10, initYB-cellHeight+10);
                contenido.setFont(font, 8);
                contenido.showText(columnasB[j-1]);
                contenido.endText();
                    
                initXB+=cellWidthB;
            }
            
            for(int j = 1; j <= colCont; j++) {
                contenido.addRect(initXC, initYC, cellWidthB, -cellHeight);
                    
                contenido.beginText();
                contenido.newLineAtOffset(initXC+10, initYC-cellHeight+10);
                contenido.setFont(font, 8);
                contenido.showText(datos[j-1]);
                contenido.endText();
                    
                initXC+=cellWidthB;
            }
            /*initX = 50;
            initY -= cellHeight;*/
                
            //}
            
            contenido.stroke();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            String total = "TOTAL: Q "+totalPDF;
            float totalA = font.getStringWidth(total) / 1000 * 15;
            contenido.newLineAtOffset((paginaWidth-totalA)/2,paginaHeight-476);
            contenido.showText(total);
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            String texto = "En espera que nuestra cotización sea de su total";
            float textoA = font.getStringWidth(texto) / 1000 * 15;
            contenido.newLineAtOffset((paginaWidth-textoA)/2,paginaHeight-506);
            contenido.showText(texto);
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            String textoB = "satisfacción y poder antender su pedido.";
            float textoBA = font.getStringWidth(textoB) / 1000 * 15;
            contenido.newLineAtOffset((paginaWidth-textoBA)/2,paginaHeight-526);
            contenido.showText(textoB);
            contenido.endText();
            
            contenido.beginText();
            contenido.setFont(font, 15);
            contenido.newLineAtOffset(50, paginaHeight-556);
            contenido.showText("Cordialmente, USAC-Delivery.");
            contenido.endText();
            
            contenido.close();
            
            documento.save("src/pdf/"+path);
            documento.close();
            
            totalPDF = "";
            
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage().toString());
        }
    }
    
    public void AbrirPDF() {
        try {
            File file = new File("src/pdf/"+path);
            Desktop.getDesktop().open(file);
        } catch(Exception ex) {
            System.out.println(ex);
        }
        path = "";
    }
    
}
