package fr.digi.m0923;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestConnexionJdbc {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        Properties properties = new Properties();
        try (InputStream input = TestConnexionJdbc.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) {
                System.out.println("Le fichier database.properties n'a pas été trouvé.");
                throw new RuntimeException("Erreur lors de la lecture du fichier database.properties");
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la lecture du fichier database.properties", e);
        }

        // Charger les informations de la base de données depuis le fichier properties
        DB_URL = properties.getProperty("database.url");
        DB_USER = properties.getProperty("database.user");
        DB_PWD = properties.getProperty("database.password");

        // Ajout d'instructions d'impression pour débuguer
        System.out.println("Chemin du fichier : " + TestConnexionJdbc.class.getClassLoader().getResource("database.properties"));
        System.out.println("URL de la base de données : " + DB_URL);
        System.out.println("Utilisateur de la base de données : " + DB_USER);
        System.out.println("Mot de passe de la base de données : " + DB_PWD);
    }

    public static void main(String[] args) {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement st = cnx.createStatement()) {
            int nb = st.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('Diginamic')");
            System.out.println("Nombre d'éléments modifiés : " + nb);
        } catch (SQLException e) {
            System.out.println("Attention : " + e.getMessage());
        }
    }
}