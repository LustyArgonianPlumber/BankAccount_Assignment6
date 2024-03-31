import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame {
    //creating objects under the Class named Account
    static Account Account1 = new Account();
    static Account account2 = new Account();
    static Account account3 = new Account();
    static Account account4 = new Account();
    static int numOfAccounts = 0;

    //Defining Panels
    static JPanel menuScreen = new JPanel();
    static JPanel screenForAdd = new JPanel();
    static JPanel listScreen = new JPanel();
    static JPanel screenForUpdate = new JPanel();
    static JPanel deleteScreen = new JPanel();
    static JPanel headerPanel = new JPanel();
    static JPanel buttonPanel = new JPanel();
    static JPanel centerPanel = new JPanel();

    //defining Add Screen labels
    static JLabel pageHeaderLbl = new JLabel(" Account Details ");
    static JLabel accountIDLbl = new JLabel(" Account ID:",
            JLabel.RIGHT);
    static JLabel typeLbl = new JLabel("Account Type:", JLabel.RIGHT);
    static JLabel holderLbl = new JLabel("Account Holder:", JLabel.RIGHT);
    static JLabel balanceLbl = new JLabel("Account Balance:", JLabel.RIGHT);
    static JLabel blankLbl1 = new JLabel("");
    static JLabel blankLbl2 = new JLabel("");
    static JLabel blankLbl3 = new JLabel("");
    static JLabel blankLbl4Add = new JLabel("");

    static JLabel pageHeaderLblUpdate = new JLabel(" Update Account ");
    static JLabel withdrawLbl = new JLabel("Withdraw:", JLabel.RIGHT);
    static JLabel depositLbl = new JLabel("Deposit:", JLabel.RIGHT);
    static JLabel blankLbl1Update = new JLabel("");
    static JLabel blankLbl2Update = new JLabel("");
    static JLabel blankLbl3Update = new JLabel("");
    static JLabel blankLbl4Update = new JLabel("");

    //defining text fields
    static JTextField tf_accountID = new JTextField(10);
    //static JTextField tf_unusedTextField = new JTextField(10);
    static JTextField tf_accountType = new JTextField(10);
    static JTextField tf_accountHolder = new JTextField(10);
    static JTextField tf_accountBalance = new JTextField(10);

    static JTextField tf_withdrawAmount = new JTextField(10);
    static JTextField tf_DepositAmount = new JTextField(10);

    //defining buttons for add screen
    static JButton submitBtnAddScreen = new JButton("Submit");
    static JButton clearBtnAddScreen = new JButton("Clear");
    static JButton backBtnAddScreen = new JButton("Back");

    static JButton submitBtnUpdateScreen = new JButton("Submit");
    static JButton clearBtnUpdateScreen = new JButton("Clear");
    static JButton backBtnUpdateScreen = new JButton("Back");

    //menu screen buttons
    static JButton addBtn = new JButton("Add Account");
    static JButton listBtn = new JButton("Account List");
    static JButton updateBtn = new JButton("Update Account");
    static JButton deleteBtn = new JButton("Delete Account");

    //entry point in to program
    public static void main(String[] args) {
//set panel layouts
        menuScreen.setLayout(new GridLayout(2, 2, 25, 25));
        screenForAdd.setLayout(new BorderLayout());
        screenForUpdate.setLayout(new BorderLayout());
        headerPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new FlowLayout());
        centerPanel.setLayout(new GridLayout(4, 3, 10, 5));
        turnOnActionListenersAdd();
        turnOnActionListenersUpdate();
        addObjectsToAddScreen();
        addObjectsToUpdateScreen();
        menuScreen.add(addBtn);
        menuScreen.add(updateBtn);
        menuScreen.add(deleteBtn);
        menuScreen.add(listBtn);

//define window frame and display
        JFrame window = new JFrame("Bank of Armenia");
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        window.add(menuScreen);
        window.add(screenForAdd);
        window.add(screenForUpdate);
        menuScreen.setVisible(true);
        screenForAdd.setVisible(false);
        screenForUpdate.setVisible(false);
        window.setSize(600, 200);
        window.setLocation(400, 400);
        window.setResizable(true);
        window.setVisible(true);
    }

    static public void addRecord() {
        numOfAccounts++;
        if (numOfAccounts == 1) {
            Account1.setID(tf_accountID.getText());
            Account1.setAccountType(tf_accountType.getText());
            Account1.setAccountBalance(tf_accountBalance.getText());
            Account1.setAccountHolder(tf_accountHolder.getText());
            clearScreenForAdd(); //when adding a record call the clear method
            JOptionPane.showMessageDialog(null, "Account 1:\nID: " +
                    Account1.getID() + "\n" + "Type: " +
                    Account1.getAccountType() + "\n" + "Holder: " +
                    Account1.getAccountHolder() + "\n" + "Balance :" + Account1.getAccountBalance());
        }
    }

    static public void clearScreenForAdd() {
        tf_accountID.setText("");
        //tf_unusedTextField.setText("");
        tf_accountType.setText("");
        tf_accountHolder.setText("");
        tf_accountBalance.setText("");
    }

    static public void clearScreenForUpdate() {
        tf_withdrawAmount.setText("");
        tf_DepositAmount.setText("");
    }

    static public void addObjectsToAddScreen() //adding objects to add screen panel
    {
//add objects to panels
        headerPanel.add(pageHeaderLbl);
        centerPanel.add(accountIDLbl); //row 1
        centerPanel.add(tf_accountID);
        centerPanel.add(blankLbl4Add);
        centerPanel.add(typeLbl); //row 2
        centerPanel.add(tf_accountType);
        centerPanel.add(blankLbl1);
        centerPanel.add(holderLbl); //row 3
        centerPanel.add(tf_accountHolder);
        centerPanel.add(blankLbl2);
        centerPanel.add(balanceLbl); //row 4
        centerPanel.add(tf_accountBalance);
        centerPanel.add(blankLbl3);
        buttonPanel.add(backBtnAddScreen);
        buttonPanel.add(submitBtnAddScreen);
        buttonPanel.add(clearBtnAddScreen);

//add sub panels to main panel.
        screenForAdd.add(headerPanel, BorderLayout.NORTH);
        screenForAdd.add(centerPanel, BorderLayout.CENTER);
        screenForAdd.add(buttonPanel, BorderLayout.SOUTH);
    }

    static public void addObjectsToUpdateScreen() {
        headerPanel.add(pageHeaderLblUpdate);
        centerPanel.add(withdrawLbl);
        centerPanel.add(tf_withdrawAmount);
        centerPanel.add(blankLbl1Update);
        centerPanel.add(depositLbl);
        centerPanel.add(tf_DepositAmount);
        centerPanel.add(blankLbl2Update);
        //centerPanel.add(blankLbl3Update);
        //centerPanel.add(blankLbl4Update);
        buttonPanel.add(backBtnUpdateScreen);
        buttonPanel.add(submitBtnUpdateScreen);
        buttonPanel.add(clearBtnUpdateScreen);


//add sub panels to main panel.

        screenForUpdate.add(headerPanel, BorderLayout.NORTH);
        screenForUpdate.add(centerPanel, BorderLayout.CENTER);
        screenForUpdate.add(buttonPanel, BorderLayout.SOUTH);
    }

    ////all action listeners are done here
    static public void turnOnActionListenersAdd() {
//turn on action listener for submit button
// Menu buttons
        addBtn.addActionListener(e -> {
            menuScreen.setVisible(false);
            screenForAdd.setVisible(true);
        });
//Add screen buttons
        submitBtnAddScreen.addActionListener(e -> addRecord());

        clearBtnAddScreen.addActionListener(e -> {
            clearScreenForAdd(); //also call the clear method
        });
        backBtnAddScreen.addActionListener(e -> {
            menuScreen.setVisible(true);
            screenForAdd.setVisible(false);
        });

    }

    static public void turnOnActionListenersUpdate() {
        updateBtn.addActionListener(e -> {
            menuScreen.setVisible(false);
            screenForUpdate.setVisible(true);
        });
        clearBtnUpdateScreen.addActionListener(e -> {
            clearScreenForUpdate(); //also call the clear method
        });
        backBtnUpdateScreen.addActionListener(e -> {
            menuScreen.setVisible(true);
            screenForUpdate.setVisible(false);
        });
    }
}
class Account
{
    private String accountType;
    private String accountHolder;
    private String accountBalance;
    private String ID;
    static private int AccountCount=0;

    private String withdrawAmount;
    private String depositAmount;
    /******************* Mutator Methods ****************/
    public void setAccountType (String accountType)
    {
        this.accountType= accountType;
        AccountCount++;
    }
     public void setAccountHolder (String accountHolder)
    {
        this.accountHolder= accountHolder;
    }
    public void setID (String ID)
    {
        this.ID= ID;
    }
    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
    /******************* Accessor Methods ****************/
    public String getAccountType()
    {
        return accountType;
    }
    public String getID()
    {
        return ID;
    }
    public String getAccountHolder()
    {
        return accountHolder;
    }
    public String getAccountBalance()
    {
        return accountBalance;
    }
    static public int getAccountCount()
    {
        return AccountCount;
    }
}
