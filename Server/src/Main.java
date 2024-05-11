//import Request.Request;
//import Request.RequestReader;
//import Response.*;
//import controller.ConsoleController;
//import controller.RequestHandler;
//import model.RouteModel;
//import model.strategy.CsvFileStrategy;
//
//import java.io.*;
//import java.nio.ByteBuffer;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Scanner;
//
//public class Main
//{
//    public static void main(String[] args) throws IOException
//    {
//        CsvFileStrategy csvFileStrategy = null;
//        Scanner scanner = new Scanner(System.in);
//        if (args.length == 0)
//        {
//            System.out.println("Не получен путь к файлу, введите его:");
//            args = new String[]{scanner.nextLine()};
//        }
//        while (true)
//        {
//            try
//            {
//                csvFileStrategy = new CsvFileStrategy(args[0]);
//                break;
//            } catch (IllegalArgumentException e)
//            {
//                System.out.println(e.getMessage());
//                args = new String[]{scanner.nextLine()};
//
//            }
//        }
//        RouteModel model = new RouteModel(csvFileStrategy);
//        System.out.println(model.initialize());
//        ConsoleController controller = new ConsoleController(model);
//        RequestHandler requestHandler = new RequestHandler(controller);
//        Path requests = Paths.get("/Users/glebarbuzov/labs/lab6client1/requestFile");
//        Path responces = Paths.get("/Users/glebarbuzov/labs/lab6client1/responceFile");
//        ObjectInputStream inputStream = null;
//        InputStream inputStream1 = Files.newInputStream(responces);
//        while (true)
//        {
//            try
//            {
//                inputStream = new ObjectInputStream(inputStream1);
//                break;
//            } catch (EOFException e)
//            {
//            }
//        }
//
//        ResponceWriter.setOutputStream(new ObjectOutputStream(Files.newOutputStream(requests)));
//        RequestReader.setInputStream(inputStream);
//        while (!Thread.currentThread().isInterrupted())
//        {
//            if (inputStream.available() > 0)
//            {
//                Request request = RequestReader.getRequest();
//                Response response = requestHandler.handleRequest(request);
//                ResponceWriter.writeResponse(response);
//            }
//            if (scanner.hasNext())
//            {
//                String word = scanner.nextLine();
//                if (word.equals("exit")) Thread.currentThread().interrupt();
//            }
//        }
//    }
//}
