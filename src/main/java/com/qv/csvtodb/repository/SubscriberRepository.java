package com.qv.csvtodb.repository;

import com.qv.csvtodb.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface SubscriberRepository extends JpaRepository<Subscriber,Long>
{
}
