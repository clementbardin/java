import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private List<Account> accounts; // Liste des comptes bancaires
    private Account currentAccount; // Compte bancaire actuel

    public ATM() {
        accounts = new ArrayList<>(); // Initialisation de la liste des comptes
        currentAccount = null; // Le compte bancaire actuel est initialisé à null
    }

    public void createAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrer le numéro de compte : ");
        String accountNumber = scanner.nextLine();

        System.out.print("Entrer le nom du client : ");
        String name = scanner.nextLine();

        System.out.print("Entrer l'adresse du client : ");
        String address = scanner.nextLine();

        System.out.print("Entrer le code postal du client : ");
        String postalCode = scanner.nextLine();

        System.out.print("Entrer la ville du client : ");
        String city = scanner.nextLine();

        Customer customer = new Customer(name, address, postalCode, city); // Création d'un nouveau client
        Account account = new Account(accountNumber, customer); // Création d'un nouveau compte bancaire avec le client
        accounts.add(account); // Ajout du compte à la liste des comptes

        System.out.println("Compte créé avec succès.");
    }

    public void selectAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                currentAccount = account; // Sélection du compte bancaire actuel
                System.out.println("Compte sélectionné avec succès.");
                return;
            }
        }

        System.out.println("Compte introuvable.");
    }

    public double getAccountBalance() {
        if (currentAccount != null) {
            return currentAccount.getBalance(); // Récupération du solde du compte bancaire actuel
        }

        return 0.0;
    }

    public void deposit(double amount) {
        if (currentAccount != null) {
            currentAccount.deposit(amount); // Effectuer un dépôt sur le compte bancaire actuel
            System.out.println("Dépôt effectué avec succès.");
        } else {
            System.out.println("Aucun compte sélectionné.");
        }
    }

    public void withdraw(double amount) {
        if (currentAccount != null) {
            boolean success = currentAccount.withdraw(amount); // Effectuer un retrait sur le compte bancaire actuel

            if (success) {
                System.out.println("Retrait effectué avec succès.");
            } else {
                System.out.println("Solde insuffisant.");
            }
        } else {
            System.out.println("Aucun compte sélectionné.");
        }
    }

    public void getTransactionHistory() {
        if (currentAccount != null) {
            List<String> transactions = currentAccount.getTransactionHistory(); // Récupérer l'historique des transactions du compte bancaire actuel

            if (transactions.isEmpty()) {
                System.out.println("Aucun historique de transaction.");
            } else {
                System.out.println("Historique des transactions :");
                for (String transaction : transactions) {
                    System.out.println(transaction);
                }
            }
        } else {
            System.out.println("Aucun compte sélectionné.");
        }
    }

    public void updateCustomerInfo(String name, String address, String postalCode, String city) {
        if (currentAccount != null) {
            Customer customer = currentAccount.getCustomer();
            customer.setName(name);
            customer.setAddress(address);
            customer.setPostalCode(postalCode);
            customer.setCity(city);

            System.out.println("Informations client mises à jour avec succès.");
        } else {
            System.out.println("Aucun compte sélectionné.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n----- Menu ATM -----");
            System.out.println("1. Créer un compte");
            System.out.println("2. Sélectionner un compte");
            System.out.println("3. Obtenir le solde du compte");
            System.out.println("4. Déposer de l'argent");
            System.out.println("5. Retirer de l'argent");
            System.out.println("6. Historique des transactions");
            System.out.println("7. Mettre à jour les informations du client");
            System.out.println("8. Quitter");

            System.out.print("Entrer votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer le caractère de nouvelle ligne

            switch (choice) {
                case 1:
                    atm.createAccount();
                    break;
                case 2:
                    System.out.print("Entrer le numéro de compte : ");
                    String accountNumber = scanner.nextLine();
                    atm.selectAccount(accountNumber);
                    break;
                case 3:
                    double balance = atm.getAccountBalance();
                    System.out.println("Solde du compte : " + balance);
                    break;
                case 4:
                    System.out.print("Entrer le montant du dépôt : ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 5:
                    System.out.print("Entrer le montant du retrait : ");
                    double withdrawalAmount = scanner.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 6:
                    atm.getTransactionHistory();
                    break;
                case 7:
                    System.out.print("Entrer le nom du client : ");
                    String name = scanner.nextLine();

                    System.out.print("Entrer l'adresse du client : ");
                    String address = scanner.nextLine();

                    System.out.print("Entrer le code postal du client : ");
                    String postalCode = scanner.nextLine();

                    System.out.print("Entrer la ville du client : ");
                    String city = scanner.nextLine();

                    atm.updateCustomerInfo(name, address, postalCode, city);
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        System.out.println("Merci d'utiliser le distributeur automatique de billets.");
    }
}
