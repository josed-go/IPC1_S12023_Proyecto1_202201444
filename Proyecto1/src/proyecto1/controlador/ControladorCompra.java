package proyecto1.controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import proyecto1.modelo.DatosFacturacion;
import proyecto1.modelo.Region;

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
    ControladorDatosFacturacion controladorDF = new ControladorDatosFacturacion();
    
    String path;
    String totalPDF;
    static double totalIngresos;
    static int cantidadPaquetes;
    
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
        Region reg = controladorR.ObtenerRegionSeleccionada(controladorD.ObtenerDepartamentoNombre(deparD).getCodigoRegion());
        reg.setNumEnvios(reg.getNumEnvios()+1);
        
        if(tipoPago.equalsIgnoreCase("Contra entrega")) {
            totalC = totalC +5;
            arrayCompra.add(new Compras(String.valueOf(arrayCompra.size()+1),depaO, muniO, direccionO, deparD, muniD, direccionD, "IPC1D"+CodigoPaquete(), tipoRegion, cantidad, peso, tipoPago, datosF, String.valueOf(totalC), usuario.UsuarioLogeado().getCorreo(), String.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)), String.valueOf(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME)) ));
            
        } else if (tipoPago.equalsIgnoreCase("con tarjeta")) {
            arrayCompra.add(new Compras(String.valueOf(arrayCompra.size()+1),depaO, muniO, direccionO, deparD, muniD, direccionD, "IPC1D"+CodigoPaquete(), tipoRegion, cantidad, peso, tipoPago,numeroT, datosF, String.valueOf(totalC), usuario.UsuarioLogeado().getCorreo(),  String.valueOf(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)), String.valueOf(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME))));
        }
        totalIngresos = totalIngresos+totalC;
        cantidadPaquetes = cantidadPaquetes+Integer.parseInt(cantidad);
        
        usuario.UsuarioLogeado().setPaquetesEnviados(usuario.UsuarioLogeado().getPaquetesEnviados()+Integer.parseInt(cantidad));
    }
    
    public double ObtenerIngreso() {
        return totalIngresos;
    }
    
    public int ObtenerPaquetes() {
        return cantidadPaquetes;
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
                arrayCompraUsuario.add(new Compras(c.getNoFactura(),c.getDepartamentoO(),c.getMuicipioO(),c.getDepartamentoO(), c.getDepartamentoD(), c.getMunicipioD(), c.getDireccionD(), c.getIdPaquete(), c.getTipoServicio(),c.getNumeroP(),c.getPesoP(), c.getTipoPago(),c.getNumeroTarjeta(), c.getDatosFacturacion(),c.getTotal(), c.getUsuario(), c.getfecha(), c.getHora()));
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
            
            path = "Cotizacion_"+CodigoPaquete()+"-"+usuario.UsuarioLogeado().getNombre()+".pdf";
            
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
            
            documento.save("src/documentos/pdf/"+path);
            documento.close();
            
            totalPDF = "";
            
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage().toString());
        }
    }
    
    public void AbrirPDF() {
        try {
            File file = new File("src/documentos/pdf/"+path);
            Desktop.getDesktop().open(file);
        } catch(Exception ex) {
            System.out.println(ex);
        }
        path = "";
    }
    
    public Compras FacturaSeleccionada(String codigoPaquete) {
        for(Compras c: arrayCompraUsuario) {
            if(c.getIdPaquete().equals(codigoPaquete)) {
                return c;
            }
        }
        return null;
    }
    
    public void GenerarFactura(String codigoPaquete) {
        Compras compraF;
        String nit = "";
        String nombreF = "";
        String direccion = "";
        StringBuilder codigoHTML = new StringBuilder();
        
        compraF = FacturaSeleccionada(codigoPaquete);
        
        for(DatosFacturacion df: controladorDF.ObtenerDatos()) {
            if((df.getNombre()+" "+df.getApellido()+", "+df.getDireccion()).equals(compraF.getDatosFacturacion())) {
                nit = df.getNit();
                nombreF = df.getNombre()+" "+df.getApellido();
                direccion = df.getDireccion();
            }
        }
        
        codigoHTML.append("<html>");
        codigoHTML.append("<head>");
        codigoHTML.append("<title>Factura"+compraF.getIdPaquete()+"</title>");
        codigoHTML.append("</head>");
        codigoHTML.append("<body style=\"margin-left: 250px; margin-right: 250px; border: solid #3f578d; border-radius: 10px;\">");
        codigoHTML.append("<h1 style=\"text-align:center; font-size:75px;\">Factura No. "+compraF.getNoFactura()+"</h1>");
        codigoHTML.append("<div style=\"display: grid; grid-column: 2; grid-row: 1; grid-gap: 50px; margin: 35px;\">");
        codigoHTML.append("<img style=\"grid-column: 1/2;\" src=\"../../img/U-delivery.png\" height=\"274px\" width=\"459\">");
        codigoHTML.append("<div style=\"grid-column: 2/2; padding-top: 35px;\">");
        codigoHTML.append("<h2>NIT: "+nit+"</h2>");
        codigoHTML.append("<h2>Nombre: "+nombreF+"</h2>");
        codigoHTML.append("<h2>Dirección: "+direccion+"</h2>");
        codigoHTML.append("<h2>Tipo de pago: "+compraF.getTipoPago()+"</h2>");
        codigoHTML.append("</div>");
        codigoHTML.append("</div>");
        codigoHTML.append("<hr style=\"margin: 35px;\">");
        codigoHTML.append("<div style=\"display: grid; grid-column: 2;\">");
        codigoHTML.append("<div style=\"grid-column: 1/2; align-items: center;\">");
        codigoHTML.append("<h2 style=\"margin: 35px;\">Codigo de paquete: "+compraF.getIdPaquete()+"</h2>");
        if(compraF.getTipoPago().equalsIgnoreCase("Contra entrega")) {
            codigoHTML.append("<h2 style=\"margin: 35px;\">Recargo de Q5.00</h2>");
        } else if(compraF.getTipoPago().equalsIgnoreCase("Con tarjeta")) {
            codigoHTML.append("<h2 style=\"margin: 35px;\">Numero tarjeta: "+compraF.getNumeroTarjeta()+"</h2>");
        }
        codigoHTML.append("</div>");
        codigoHTML.append("<div style=\"grid-column: 2/2;\">");
        codigoHTML.append("<h2 style=\"margin: 35px;  text-align: right;\">Fecha: "+compraF.getfecha()+"</h2>");
        codigoHTML.append("<h2 style=\"margin: 35px;  text-align: right;\">Hora: "+compraF.getHora()+"</h2>");
        codigoHTML.append("</div>");
        codigoHTML.append("</div>");
        codigoHTML.append("<div style=\"margin: 35px; text-align: center; align-items: center; \">");
        codigoHTML.append("<table style=\"margin: 0 auto; width: 100%;\" border=\"1\">");
        codigoHTML.append("<tr style=\"background-color: #acd3ff ;\">");
        codigoHTML.append("<th >Departamento Origen</th>");
        codigoHTML.append("<th >Municipio Origen</th>");
        codigoHTML.append("<th >Departamento Destino</th>");
        codigoHTML.append("<th >Municipio Destino</th>");
        codigoHTML.append("<th >Tamaño paquete</th>");
        codigoHTML.append("<th >Numero de paquetes</th>");
        codigoHTML.append("<th>Total</th>");
        codigoHTML.append("</tr>");
        codigoHTML.append("<tr>");
        codigoHTML.append("<td>"+compraF.getDepartamentoO()+"</td>");
        codigoHTML.append("<td>"+compraF.getMuicipioO()+"</td>");
        codigoHTML.append("<td>"+compraF.getDepartamentoD()+"</td>");
        codigoHTML.append("<td>"+compraF.getMunicipioD()+"</td>");
        codigoHTML.append("<td>"+compraF.getPesoP()+"</td>");
        codigoHTML.append("<td>"+compraF.getNumeroP()+"</td>");
        codigoHTML.append("<td>Q"+compraF.getTotal()+"</td>");
        codigoHTML.append("</tr>");
        codigoHTML.append("</table>");
        codigoHTML.append("</div>");
        codigoHTML.append("</body>");
        codigoHTML.append("</html>");
        
        try {
            File file = new File("src/documentos/facturas/Factura-No"+compraF.getNoFactura()+"-"+compraF.getIdPaquete()+".html");
            FileWriter html = new FileWriter(file);
            html.write(codigoHTML.toString());
            html.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void GenerarGuia(String codigoPaquete) {
        Compras compraF;
        String nombreD = "";
        StringBuilder codigoHTML = new StringBuilder();
        
        compraF = FacturaSeleccionada(codigoPaquete);
        
        for(DatosFacturacion df: controladorDF.ObtenerDatos()) {
            if((df.getNombre()+" "+df.getApellido()+", "+df.getDireccion()).equals(compraF.getDatosFacturacion())) {
                nombreD = df.getNombre()+" "+df.getApellido();
            }
        }
        
        codigoHTML.append("<html>");
        codigoHTML.append("<head>");
        codigoHTML.append("<meta charset=\"UTF-8\">");
        codigoHTML.append("<link href='https://fonts.googleapis.com/css?family=Libre Barcode 39' rel='stylesheet'>");
        codigoHTML.append("<title>Guía "+compraF.getIdPaquete()+"</title>");
        codigoHTML.append("</head>");
        codigoHTML.append("<body style=\"margin-left: 250px; margin-right: 250px; border: solid #3f578d; border-radius: 10px;\">");
        codigoHTML.append("<h1 style=\"text-align:center; font-size:75px;\">Guía "+compraF.getIdPaquete()+"</h1>");
        codigoHTML.append("<div style=\"margin: 0px 200px 30px 200px; border: solid #7293e7; padding: 25px; display: grid; grid-column: 2;\">");
        codigoHTML.append("<div style=\"grid-column: 1/2; margin-right: 35px;\">");
        codigoHTML.append("<h2>ORIGEN: "+compraF.getDepartamentoO()+" / "+compraF.getMuicipioO()+"</h2>");
        codigoHTML.append("<h2>DESTINO: "+compraF.getDepartamentoD()+" / "+compraF.getMunicipioD()+"</h2>");
        codigoHTML.append("<h2>NOMBRE DE ORIGEN: "+usuario.UsuarioLogeado().getNombre()+" "+usuario.UsuarioLogeado().getApellido()+"</h2>");
        codigoHTML.append("<h2>NOMBRE DESTINO: "+nombreD+"</h2>");
        codigoHTML.append("<h2>FECHA: "+compraF.getfecha()+"</h2>");
        codigoHTML.append("<h2>FECHA: "+compraF.getHora()+"</h2>");
        codigoHTML.append("</div>");
        codigoHTML.append("<div style=\"grid-column: 2/2; border-left: solid #7293e7; align-items: center; display: flex; align-items: center; justify-content: center; flex-wrap: wrap;\">");
        codigoHTML.append("<h2 style=\"text-align: center;\": center;\">CANTIDAD: "+compraF.getNumeroP()+"</h2>");
        codigoHTML.append("<h2 style=\"text-align: center;\": center;\">TAMAÑO DE PAQUETE: "+compraF.getPesoP()+"</h2>");
        codigoHTML.append("</div>");
        codigoHTML.append("</div>");
        codigoHTML.append("<div style=\"margin-right: 250px; margin-left: 250px; text-align: center;\">");
        codigoHTML.append("<h2 style=\" margin: 0;\">CÓDIGO DE PAQUETE: "+compraF.getIdPaquete()+"</h2>");
        codigoHTML.append("<p style=\"font-family: 'Libre Barcode 39';font-size: 200px; margin: 10px;\">"+compraF.getIdPaquete()+"</p>");
        codigoHTML.append("</div>");
        codigoHTML.append("</body>");
        codigoHTML.append("</html>");
        
        try {
            File file = new File("src/documentos/guias/Guia-"+compraF.getIdPaquete()+".html");
            FileWriter html = new FileWriter(file);
            html.write(codigoHTML.toString());
            html.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}
