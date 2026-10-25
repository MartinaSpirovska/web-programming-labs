package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("bookReservation")
public class BookReservationController {
    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String placeReservation(Model model,
                                   @RequestParam String title,
                                   @RequestParam String readerName,
                                   @RequestParam String readerAddress,
                                   @RequestParam Integer numCopies){
        bookReservationService.placeReservation(title, readerName, readerAddress, numCopies);
        model.addAttribute("reservation", new BookReservation(title, readerName, readerAddress, (long) numCopies));
        return "reservationConfirmation";
    }
}
