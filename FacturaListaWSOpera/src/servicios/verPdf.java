package servicios;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Properties;

import org.apache.axis2.AxisFault;

import bd.Direccionador;
import controlador.services;
import servicios.FacturaElectronicaImplServiceStub.GetImprimibleResponse;


public class verPdf {

	
	private FacturaElectronicaImplServiceStub inicializar() throws AxisFault {
		Properties propiedades = Direccionador.getInstance().getArchivoConfiguracion();
		FacturaElectronicaImplServiceStub fstub = new FacturaElectronicaImplServiceStub(
				propiedades.getProperty("endpoint"));

		return fstub;

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		

	}
	
	public GetImprimibleResponse generarPdf(String serie, String numero, String tipocfe,String comando) throws IOException {
		Properties propiedades = Direccionador.getInstance().getArchivoConfiguracion();
		String ruta = propiedades.getProperty("imprimibles");

		services service = new services();
		FacturaElectronicaImplServiceStub fstub = null;
		int contador = 0;
		
		servicios.FacturaElectronicaImplServiceStub.GetImprimibleResponse res = null;

		
		try {
			fstub = inicializar();
			res = service.getImprimible("A",numero,tipocfe,fstub);
			System.out.println(res);
			// btn_facturados.setSelected(true);
		} catch (AxisFault e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//String b64 = "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Zz4+CmVuZG9iagozIDAgb2JqCjw8L1R5cGUvUGFnZXMvQ291bnQgMS9LaWRzWzQgMCBSXT4+CmVuZG9iagoxMCAwIG9iago8PC9UeXBlL0NhdGFsb2cvUGFnZXMgMyAwIFI+PgplbmRvYmoKMTEgMCBvYmoKPDwvUHJvZHVjZXIoaVRleHSuIDUuNC4xIKkyMDAwLTIwMTIgMVQzWFQgQlZCQSBcKEFHUEwtdmVyc2lvblwpKS9Nb2REYXRlKEQ6MjAyMTEwMjcxNjMzMTgtMDMnMDAnKS9DcmVhdGlvbkRhdGUoRDoyMDIxMTAyNzE2MzMxOC0wMycwMCcpPj4KZW5kb2JqCnhyZWYKMCAxMgowMDAwMDAwMDAwIDY1NTM1IGYgCjAwMDAwMDAyOTQgMDAwMDAgbiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDExNzExIDAwMDAwIG4gCjAwMDAwMDAxMzMgMDAwMDAgbiAKMDAwMDAwMzUwMiAwMDAwMCBuIAowMDAwMDA0MTgzIDAwMDAwIG4gCjAwMDAwMTEzNDAgMDAwMDAgbiAKMDAwMDAxMTUzMCAwMDAwMCBuIAowMDAwMDExNjE4IDAwMDAwIG4gCjAwMDAwMTE3NjIgMDAwMDAgbiAKMDAwMDAxMTgwOCAwMDAwMCBuIAp0cmFpbGVyCjw8L1Jvb3QgMTAgMCBSL0lEIFs8YTljMzAzYjExNDhkMDNjYjI0ZmRlOGRmMjQzZjJhZTU+PDk1ZmExOTg5MjQxYTJkMDM2NmU1YWZhM2VjYTFkOWRlPl0vSW5mbyAxMSAwIFIvU2l6ZSAxMj4+CiVpVGV4dC01LjQuMQpzdGFydHhyZWYKMTE5NjIKJSVFT0YK";
	    String file = ruta+"/factura"+numero+".pdf";
	    String rutaChrome = "start chrome "+file;

	      System.out.println("PDF File Saved");
	      if(comando.equals("ver")) {
	      try {
	    	  	Runtime.getRuntime().exec(new String[]{"cmd", "/c", rutaChrome});
	    	    System.out.println("Google Chrome launched!");
	    	} catch (Exception e) {
	    	    e.printStackTrace();
	    	    //JOptionPane.WARNING_MESSAGE
	    	}
	      }
	    
	    return res;
	}

}
