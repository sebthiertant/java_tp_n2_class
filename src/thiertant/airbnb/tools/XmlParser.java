package thiertant.airbnb.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import thiertant.airbnb.lodgings.Appartment;
import thiertant.airbnb.lodgings.House;
import thiertant.airbnb.users.Host;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XmlParser {

    private static final String FILENAME = "src/ressources/lodgings.xml";

    public void ParseXml(ArrayList arrayList){

        try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(FILENAME));
        doc.getDocumentElement().normalize();


        // On itère sur le nombre des appartements
        NodeList appartmentList = doc.getElementsByTagName("Appartement");
        for (int i = 0; i < appartmentList.getLength(); i++) {

            // on assigne les noeuds d'hotes a une variable et on instancie les objets Host
            NodeList hostList = doc.getElementsByTagName("hote");
            Node nodeHost = hostList.item(i);


            // On assigne tous les attributs des hotes par appartement puis on instancie l'Host
            Element eElement = (Element) nodeHost;
            String firstName = eElement.getElementsByTagName("prenom").item(0).getTextContent();
            String lastName = eElement.getElementsByTagName("nom").item(0).getTextContent();
            int age = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
            int answerDelay = Integer.parseInt(eElement.getElementsByTagName("delaiReponse").item(0).getTextContent());
            Host host = new Host(firstName, lastName, age, answerDelay);

            // on récupère la valeur du prix par nuit et on la parse
            NodeList pricesNodeList = doc.getElementsByTagName("tarifParNuit");
            Node price = pricesNodeList.item(i);
            int priceByNight = Integer.parseInt(price.getTextContent());

            // on récupère l'adresse
            NodeList adresseNodeList = doc.getElementsByTagName("adresse");
            Node adresses = adresseNodeList.item(i);
            String address = adresses.getTextContent();

            // on récupère la valeur de la superficie et on la parse
            NodeList superficieNodeLIst = doc.getElementsByTagName("superficie");
            Node superficies = superficieNodeLIst.item(i);
            int superficie = Integer.parseInt(superficies.getTextContent());

            // on récupère le nb de voyageurs max et on le parse
            NodeList maxTravellersNodeList = doc.getElementsByTagName("nbVoyageursMax");
            Node maxTravellersNode = maxTravellersNodeList.item(i);
            int maxTraveller = Integer.parseInt(maxTravellersNode.getTextContent());

            // on récupère le nb d'étage max et on le parse
            NodeList floorNodeList = doc.getElementsByTagName("numeroEtage");
            Node floorNode = floorNodeList.item(i);
            int floor = Integer.parseInt(floorNode.getTextContent());

            // on récupère la superficie du balcon et on la parse
            NodeList balconySurfaceNodeList = doc.getElementsByTagName("superficieBalcon");
            Node balconySurfaceNode = balconySurfaceNodeList.item(i);
            int balconySurface = Integer.parseInt(balconySurfaceNode.getTextContent());

            Appartment appartment = new Appartment(host, priceByNight,address,superficie, maxTraveller, floor, balconySurface);
            arrayList.add(appartment);
        }

        // On itère sur le nombre des maison
        NodeList housesList = doc.getElementsByTagName("Maison");
            for (int j = 0; j < housesList.getLength(); j++) {
                // on assigne les noeuds d'hotes a une variable et on instancie les objets Host
                NodeList hostList = doc.getElementsByTagName("hote");
                Node nodeHost = hostList.item(j);

                // On assigne tous les attributs des hotes par appartement puis on instancie l'Host
                Element eElement = (Element) nodeHost;
                String firstName = eElement.getElementsByTagName("prenom").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("nom").item(0).getTextContent();
                int age = Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent());
                int answerDelay = Integer.parseInt(eElement.getElementsByTagName("delaiReponse").item(0).getTextContent());
                Host host = new Host(firstName, lastName, age, answerDelay);

                // on récupère la valeur du prix par nuit et on la parse
                NodeList pricesNodeList = doc.getElementsByTagName("tarifParNuit");
                Node price = pricesNodeList.item(j);
                int priceByNight = Integer.parseInt(price.getTextContent());

                // on récupère l'adresse
                NodeList adresseNodeList = doc.getElementsByTagName("adresse");
                Node adresses = adresseNodeList.item(j);
                String address = adresses.getTextContent();

                // on récupère la valeur de la superficie et on la parse
                NodeList superficieNodeLIst = doc.getElementsByTagName("superficie");
                Node superficies = superficieNodeLIst.item(j);
                int superficie = Integer.parseInt(superficies.getTextContent());

                // on récupère le nb de voyageurs max et on le parse
                NodeList maxTravellersNodeList = doc.getElementsByTagName("nbVoyageursMax");
                Node maxTravellersNode = maxTravellersNodeList.item(j);
                int maxTraveller = Integer.parseInt(maxTravellersNode.getTextContent());

                // on récupère la superficie du jardin on la parse
                NodeList gardenNodeList = doc.getElementsByTagName("superficieJardin");
                Node gardenNode = gardenNodeList.item(j);
                int garden = Integer.parseInt(gardenNode.getTextContent());

                // on récupère la valeur du boolean de la présence de piscine
                NodeList havePoolNodeList = doc.getElementsByTagName("possedePiscine");
                Node havePoolNode = havePoolNodeList.item(j);
                Boolean havePool = Boolean.valueOf(havePoolNode.getTextContent());


                House house = new House(host, priceByNight,address,superficie, maxTraveller, garden, havePool);
                arrayList.add(house);
                }
            } catch (Exception e) {
        System.out.println("Une erreur s'est produite lors de la lecture du fichier xml");;
        }
    }
}
