package com.example.postgrescodefirst.Online.Store.repository;

import com.example.postgrescodefirst.Online.Store.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice,Long> {
}
