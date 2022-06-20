package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> ant = users.get(user);
            if (!ant.contains(account)) {
                ant.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> ant = users.get(user);
            for (Account account : ant) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account scrR = findByRequisite(srcPassport, srcRequisite);
        Account destR = findByRequisite(destPassport, destRequisite);
        if (scrR != null && destR != null && scrR.getBalance() >= amount) {
            destR.setBalance(destR.getBalance() + amount);
            scrR.setBalance(scrR.getBalance() - amount);
            return true;
        }
        return false;
    }
}