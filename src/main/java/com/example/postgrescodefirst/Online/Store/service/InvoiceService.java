package com.example.postgrescodefirst.Online.Store.service;

import com.example.postgrescodefirst.Online.Store.model.Invoice;
import com.example.postgrescodefirst.Online.Store.model.ShoppingCartItem;
import com.example.postgrescodefirst.Online.Store.model.User;
import com.example.postgrescodefirst.Online.Store.repository.InvoiceRepository;
import com.example.postgrescodefirst.Online.Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService{


    @Autowired
    private InvoiceRepository invoiceRepository;


    @Autowired
    private IShoppingCartItemService cartItemService;


    @Autowired
    private UserRepository userRepository;

    @Override
    public Invoice byUserId(long userId) {


        Invoice unpaidInvoice = findUnpaidByUserId(userId);


        if(unpaidInvoice !=null)

            return  unpaidInvoice;


        Invoice newUserInvoice = createInvoiceFromUserCart(userId);

        //TODO:Чистить корзину пользователя после создания invoice.

        return newUserInvoice;
    }


    private Invoice createInvoiceFromUserCart(long userId) {

        Invoice newInvoice = new Invoice();


        User invoiceUser = userRepository.findById(userId).get();


        newInvoice.setUser(invoiceUser);



        List<ShoppingCartItem> userCartItems = (List<ShoppingCartItem>)cartItemService.ByUserId(userId);


        double total = 0.00;

        for(ShoppingCartItem cartItem :userCartItems)
        {

            double goodsTotal = cartItem.getGoods().getPrice().doubleValue() * cartItem.getQuantity();


            total += goodsTotal;
        }


        newInvoice.setTotal(new BigDecimal(total));


        newInvoice.setIssue_date(new Date());


        Calendar cal =  Calendar.getInstance();

        cal.setTime(newInvoice.getIssue_date());


        cal.add(Calendar.DATE,3);


        newInvoice.setDue_date(cal.getTime());


        newInvoice.setIs_paid(false);


        invoiceRepository.save(newInvoice);

        return newInvoice;

    }


    public Invoice findUnpaidByUserId(long userId)

    {

        List<Invoice> allInvoices = (List<Invoice>)invoiceRepository.findAll();

        Invoice unpaidInvoiceByUserId = null;

        for(Invoice invoice:allInvoices)
        {

            if(invoice.getUser().getId() == userId && invoice.isIs_paid() == false)
            {
                unpaidInvoiceByUserId = invoice;
                break;
            }
        }
        return  unpaidInvoiceByUserId;


    }
}
