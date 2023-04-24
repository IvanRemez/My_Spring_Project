package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountDetailsRepository accountDetailsRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final UserAccountRepository userAccountRepository;

    public QueryDemo(AccountDetailsRepository accountDetailsRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, GenreRepository genreRepository, UserAccountRepository userAccountRepository) {
        this.accountDetailsRepository = accountDetailsRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.genreRepository = genreRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(accountDetailsRepository.fetchAdminAccounts());
        System.out.println(cinemaRepository.distinctBySponsoredName());
        System.out.println(movieRepository.fetchAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.fetchAllTicketsByUserAccount(4L));
        System.out.println(ticketRepository.fetchAllTicketsBetweenRangeOfDateTimes(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
        System.out.println(genreRepository.fetchAll());
        System.out.println(userAccountRepository.fetchAllUsers());

    }
}