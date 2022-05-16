package com.example.postgrescodefirst.Online.Store.controller;

import com.example.postgrescodefirst.Online.Store.model.Invoice;
import com.example.postgrescodefirst.Online.Store.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;


    @GetMapping("/invoices/{userId}")
    public Invoice prepareUserInvoice(@PathVariable(name ="userId")long userId)
    {
        return invoiceService.byUserId(userId);
    }
}
