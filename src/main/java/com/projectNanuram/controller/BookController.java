package com.projectNanuram.controller;

import com.projectNanuram.entity.Book;
import com.projectNanuram.entity.BookWrapper;
import com.projectNanuram.entity.ColorTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/showBooks")
    public String update(Model model){
//        @PathVariable("familyId") String familyId , Model model
//        Family family = familyService.getFamilyById(familyId);
//        model.addAttribute("family" , family);
//        model.addAttribute("member" , family.getMember());
//        model.addAttribute("rowNum" , family.getTotalMembers());
//        model.addAttribute("rd", ReferenceHelper.referenceData());
//        model.addAttribute("message" , "Person Information Update");
//        System.out.println(family.getMember().get(0).getFirstName());

        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Golden Eye",  "Ian Fleming", true);
        Book book2 = new Book("Golden Eye",  "Jian Fleming", false);
        Book book3 = new Book("Golden Eye",  "Bhag, Doareman hain", true);
        Book book4 = new Book("Golden Eye",  "Suzuka Fleming", true);

        ColorTest color1 = new ColorTest("c1", "RED");
        ColorTest color2 = new ColorTest("c1", "BLUE");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        List<ColorTest>colorList = new ArrayList<>();
        colorList.add(color1);
        colorList.add(color2);

        BookWrapper wrapper = new BookWrapper();
        wrapper.setBookList(bookList);
        wrapper.setColorList(colorList);
        model.addAttribute("wrapper" , wrapper);

        return "showBook";

    }
    @PostMapping("/saveBook")
//    public void saveBook(@ModelAttribute("newBook")Book newBook){
    public String saveBook(@ModelAttribute("wrapper")BookWrapper wrapper){
        for (Book book: wrapper.getBookList()) {
            System.out.print("title: "+book.getTitle()+ ", ");
            System.out.print("author: "+book.getAuthor()+ " ");
            System.out.println();
        }

        for (ColorTest colort: wrapper.getColorList()) {
            System.out.print("id: "+ colort.getColorId() + ", ");
            System.out.print("code: " + colort.getColorCode() + " ");
            System.out.println();
        }
        return "showBook";

    }
}
