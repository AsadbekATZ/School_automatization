package service;

import java.util.UUID;

public abstract class BaseService {
    protected abstract boolean add(Object object);
    protected abstract Object getById(UUID id);
}
