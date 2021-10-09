import java.util.Scanner;
class Test1{  
    public static void main(String args[]){  
        System.out.println("Your first argument is: "+args[0]);  
        
        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;
        int choice;
        String url;
        String key=null;
        int count = 0;
   
        if(args[0].equals("urldatabase")) {
            
            
             while(true){
                    
                    System.out.print("\n1.) storeurl \n");
                    System.out.print("2.) get\n");
                    System.out.print("3.) count\n");
                    System.out.print("4.) list\n");
                    System.out.print("5.) exit\n");
                    System.out.println("Enter any commands\n");

                    choice = input.nextInt();
                 
                     switch(choice){

                                case 1:
                                    //Definitions
                                    System.out.print("storeurl ");
                                    url = input.nextLine();
                                    key = url.substring(0, url.indexOf("."));
                                    break;

                                case 2: 
                                    System.out.print("get ");
                                    count ++;
                                    System.out.print(key);
                                    break;

                                case 3:
                                    System.out.print("count ");
                                    System.out.print(count);
                                    break;

                                case 4: 
                                   System.out.println("Key   count");
				   System.out.println(key+"  "+count);
                                    break;
                                case 5: 
                                    System.out.println("Exiting Program...");
                                     System.exit(0);
                                     break;
                                default :
                                     System.out.println("This is not a valid Menu Option! Please Select Another");
                                     break;

                    }
                }
            
        }
            
    }  
}  