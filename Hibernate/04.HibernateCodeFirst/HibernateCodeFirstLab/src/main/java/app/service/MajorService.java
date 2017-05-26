package app.service;

import app.entities.Major;

/**
 * Created by vladix on 5/26/17.
 */

public interface MajorService {

    void create(Major major);

    void deleteByName(String name);
}
