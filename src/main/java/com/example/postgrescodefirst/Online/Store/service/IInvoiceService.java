package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Invoice;

public interface IInvoiceService {

     Invoice byUserId(long userId);
}
