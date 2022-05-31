package br.com.devdojo.maratonajsf.bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

/**
 * Created by Bakawaii on 25/05/2022.
 */
@Named
@ConversationScoped
public class TesteConversationBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    @Inject
    private Conversation conversation;

    public void init(){
        System.out.println("Entrou no PostConstruct do ConversationScoped");
        personagens = asList("Luffy", "Zoro", "Sanji");
        if(conversation.isTransient()){
            conversation.begin();
            System.out.println("Iniciando Conversation Scoped, ID = " + conversation.getId());
        }
    }
    public String endConversation(){
        if(!conversation.isTransient()){
            conversation.end();
        }
        return "conversation?faces-redirect=true";
    }
    public void selecionarPersonagem(){
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
