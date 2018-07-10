package com.beam.helpdesk.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beam.helpdesk.domain.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
