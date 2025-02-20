import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("chatBean")
@SessionScoped
public class ChatBean implements Serializable {
    private static final List<ChatMessage> messages = new ArrayList<>();
    private String myMessage;

    @Inject
    private LoginBean loginBean;

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void sendMessage() {
        if (myMessage != null && !myMessage.trim().isEmpty()) {
            String username = loginBean.getUsername(); 
            ChatMessage newMessage = new ChatMessage(username, myMessage);
            synchronized (messages) {
                messages.add(newMessage);
            }
            myMessage = ""; 
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("chat.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
