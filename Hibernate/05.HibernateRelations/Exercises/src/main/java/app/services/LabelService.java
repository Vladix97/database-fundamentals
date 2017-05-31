package app.services;


import app.entities.labels.ClassicLabel;

public interface LabelService {

    void persist(ClassicLabel label);

    ClassicLabel findBy(long id);
}
