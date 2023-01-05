package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Commentaire;
import com.odc.backend.Repository.CommentaireRepository;
import com.odc.backend.Service.CommentaireService;

@Service
public class CommentaireImpl implements CommentaireService{

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public Commentaire saveCommentaire(Commentaire commentaire) {
        // TODO Auto-generated method stub
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(Commentaire commentaire) {
        // TODO Auto-generated method stub
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire getCommentaire(Long id) {
        // TODO Auto-generated method stub
        return commentaireRepository.findById(id).get();
    }

    @Override
    public void deleteCommentaire(Commentaire commentaire) {
        // TODO Auto-generated method stub
        commentaireRepository.delete(commentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire() {
        // TODO Auto-generated method stub
        return commentaireRepository.findAll();
    }
    
}
