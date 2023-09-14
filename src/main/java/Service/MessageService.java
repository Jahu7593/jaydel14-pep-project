package Service;

import Model.Account;
import Model.Message;
import DAO.AccountDAO;
import DAO.MessageDAO;
import java.util.List;

public class MessageService {

    MessageDAO messageDAO;
    AccountDAO accountDAO;

    public MessageService(){
        this.messageDAO = new MessageDAO();
        this.accountDAO = new AccountDAO();
    }

    public Message newMessage(Message message) {
        List<Account> accounts = accountDAO.getAllAccounts();
        if(!message.getMessage_text().isEmpty() && message.getMessage_text().length() < 255){
            for(Account ac : accounts){
                if(ac.getAccount_id() == message.getPosted_by()){
                    return messageDAO.mkMessage(message);
                }
            }
        }
        return null;
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageByID(int id) {
        return messageDAO.getMessageByID(id);
    }
}
