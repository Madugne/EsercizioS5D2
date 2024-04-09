package chunyin.EsercizioS5D2.services;

import chunyin.EsercizioS5D2.entities.Autore;
import chunyin.EsercizioS5D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    private List<Autore> autoreList = new ArrayList<>();
    public List<Autore> getUsersList(){
        return this.autoreList;
    }
    public Autore saveAutore(Autore body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,100));
        this.autoreList.add(body);
        return body;
    }

    public Autore findById(int id){
        Autore found = null;
        for(Autore autore: this.autoreList){
            if(autore.getId() == id) found = autore;
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public Autore findByIdAndUpdate(int id, Autore updatedUser){
        Autore found = null;
        for(Autore user: this.autoreList){
            if(user.getId() == id) {
                found = user;
                found.setNome(updatedUser.getNome());
                found.setCognome(updatedUser.getCognome());
            }
        }
        if(found == null) throw new NotFoundException(id);
        else return found;
    }

    public void findByIdAndDelete(int id){
        Iterator<Autore> iterator = this.autoreList.iterator();

        while(iterator.hasNext()){
            Autore current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }

    }
}
