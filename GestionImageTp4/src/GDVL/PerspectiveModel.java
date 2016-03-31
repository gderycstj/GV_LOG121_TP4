package GDVL;

public class PerspectiveModel {
	
	private int niveauZoom;
	private int degreTranslation;
	
	String Path;
	
	PerspectiveModel()
	{
		Path = "";
	}
	public void setPath(String pathImage)
	{
		Path = pathImage;
	}
	
	public void effectuerZoom()
	{
		niveauZoom+=20;
		System.out.println("Niveau Zoom: " + niveauZoom);
	}
	
	public void effectuerZoomContraire()
	{
		niveauZoom-=20;
		System.out.println("Niveau Zoom: " + niveauZoom);
	}
	
	public void effectuerTranslation()
	{
		degreTranslation+=20;
		System.out.println("Niveau Translation: " + degreTranslation);
		
	}
	
	public void effectuerTranslationContraire()
	{
		degreTranslation-=20;
		System.out.println("Niveau Translation: " + degreTranslation);
	}
	
	public int getTranslation()
	{
		return degreTranslation;
	}

}

