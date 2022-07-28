package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского перевода.
 * @version 1.0
 */

public class BankService {
    /**
     * Поле содержит всех пользователей с их счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в список.
     * @param user - объект класса User.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет счет пользователю.
     * Пользователь ищется по поспорту сравнеием со всем списком.
     * Далее проверяется что у пользователя нет добвляемого счета.
     * @param passport - паспорт пользователя.
     * @param account - счет пользователя.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> ant = users.get(user);
            if (!ant.contains(account)) {
                ant.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * Сравниваются номера паспорта.
     * Если пользователь не найден, метод вернет null.
     * @param passport - паспорт пользователя.
     * @return паспорт найденого пользователя, либо null .
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Сначала ищется пользователь методом findByPassport.
     * Если пользователь найден, то получаем список его счетов и ищем счет по реквизитам.
     * Если счет пользователь или счет не найден то метод вернет null.
     * @param passport - паспорт пользователя.
     * @param requisite - реквизиты счета.
     * @return null, либо счет пользователя.
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет переводить деньги с одного счета на другой.
     * Метод проверяет наличие счетов методом findByRequisite.
     * Также метод проверяет хватает ли денег на счету отправаителя.
     * @param srcPassport паспорт отправителя.
     * @param srcRequisite реквизиты отправителя.
     * @param destPassport паспорт получателя.
     * @param destRequisite реквизиты получателя.
     * @param amount сумма перевода.
     * @return если счета найдены и хватает денег то true, если условия не выполнены то false.
     */
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