import repository.ImdbApiClient;

public class Application {
    public static void main(String[] args)  {

         final var api = new ImdbApiClient();
         final var response = api.getImdbTop250();




    }

}
