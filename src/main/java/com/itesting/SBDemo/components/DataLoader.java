package com.itesting.SBDemo.components;

import com.itesting.SBDemo.models.Bank;
import com.itesting.SBDemo.models.Person;
import com.itesting.SBDemo.models.Shirt;
import com.itesting.SBDemo.respositories.BankRepository;
import com.itesting.SBDemo.respositories.PersonRepository;
import com.itesting.SBDemo.respositories.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ShirtRepository shirtRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        Bank bank1 = new Bank("HSBC", 0.11f);
        Bank bank2 = new Bank("Bradford and Bingley", 1.01f);
        Bank bank3 = new Bank("Chip", 1.25f);

        bankRepository.save(bank1);
        bankRepository.save(bank2);
        bankRepository.save(bank3);

        Person person1 = new Person("Craig", 25000);
        Person person2 = new Person("Alejandra", 75000);
        Person person3 = new Person("Margot", 12000);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);

        Shirt shirt1 = new Shirt("Red", 17.5f, person1);
        Shirt shirt2 = new Shirt("Blue", 16f, person3);
        Shirt shirt3 = new Shirt( "Orange", 16.5f, person2);

        shirtRepository.save(shirt1);
        shirtRepository.save(shirt2);
        shirtRepository.save(shirt3);

        person1.addBank(bank1);
        person1.addBank(bank2);

        person2.addBank(bank2);
        person2.addBank(bank3);

        person3.addBank(bank1);

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);



    }
}
