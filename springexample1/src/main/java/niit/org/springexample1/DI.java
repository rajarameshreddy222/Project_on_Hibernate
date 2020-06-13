package niit.org.springexample1;

public class DI
{
   public static void main (String args[]) 
   {
	   App obj=new App();
       obj.choice(new Bike());
	   obj.choice(new Car());
   }
   
	
}
