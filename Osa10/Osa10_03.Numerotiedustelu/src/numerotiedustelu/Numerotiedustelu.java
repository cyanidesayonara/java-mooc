package numerotiedustelu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santtu
 */
import java.util.*;
import java.util.stream.Collectors;

public class Numerotiedustelu {
    private TextUI textui;
    private Map<String, List<String>> numbers;
    private Map<String, String> address;
    
    public Numerotiedustelu(TextUI textui) {
        this.textui = textui;
        this.numbers = new HashMap();
        this.address = new HashMap();
    }
    
    public void start() {
        textui.welcome();
        boolean x = true;
        while (x) {
            switch(textui.command()) {
                case "1":
                    addNumber(textui.addNumber());
                    break;
                case "2":
                    if (!getNumber(textui.askName(), "  ")) {
                        System.out.println("  ei löytynyt");
                    };
                    break;
                case "3":
                    getName(textui.askNumber());
                    break;
                case "4":
                    addAddress(textui.addAddress());
                    break;
                case "5":
                    getInfo(textui.askName(), "  ");
                    break;
                case "6":
                    deleteName(textui.askNameDel());
                    break;
                case "7":
                    filterList(textui.askKeyword());
                    break;
                case "x":
                    x = false;
                    break;
            }
        }
    }
    
    public void addNumber(String[] number) {
        numbers.putIfAbsent(number[0], new ArrayList());
        numbers.get(number[0]).add(number[1]);
    }
    
    public boolean getNumber(String name, String tab) {
        List<String> numbers = this.numbers.getOrDefault(name, new ArrayList());
        if (numbers.isEmpty()) {
            return false;
        } else {
            numbers.forEach(n -> System.out.println(tab + n));
            return true;
        }
    }
    
    public void getName(String number) {
        numbers.entrySet().stream().forEach(k -> {
            if (k.getValue().contains(number)) {
                System.out.println("  " + k.getKey());
            } else {
                System.out.println("  ei löytynyt");
            }
        });
    };
    
    public void addAddress(String[] address) {
        this.address.put(address[0], address[1]);
    }
    
    public boolean getAddress(String name, String tab) {
        String address = this.address.getOrDefault(name, "");
        if (address.isEmpty()) {
            return false;
        } else {
            System.out.println(tab + "osoite: " + address);
            return true;
        }
    }
    
    public void getInfo(String name, String tab) {
        if (!numbers.containsKey(name) && !address.containsKey(name)) {
            System.out.println("  ei löytynyt");
        } else {
            if (!getAddress(name, tab)) {
                System.out.println(tab + "osoite ei tiedossa");
            }
            if (!numbers.getOrDefault(name, new ArrayList()).isEmpty()) {
                System.out.println(tab + "puhelinnumerot:");
            }
            if (!getNumber(name, tab + "  ")) {
                System.out.println(tab + "ei puhelinta");
            }
        }
    }
    
    public void deleteName(String name) {
        numbers.remove(name);
        address.remove(name);
    }
    
    public void filterList(String keyword) {
        List<String> list = new ArrayList();
        numbers.keySet().stream().filter(k -> k.contains(keyword))
                .forEach(k -> list.add(k));
        
        address.keySet().stream().filter(k -> k.contains(keyword))
                .forEach(k -> {
                if (!list.contains(k)) {
                    list.add(k);
                }
                });
        address.entrySet().stream().filter(k -> k.getValue().contains(keyword))
                .forEach(k -> {
                if (!list.contains(k.getKey())) {
                    list.add(k.getKey());
                }
                });
        if (list.isEmpty()) {
            System.out.println("  ei löytynyt");
        } else {
            Collections.sort(list);
            list.forEach(l -> {
                System.out.println("  " + l);
                getInfo(l, "    ");
            });
        }
    }
}
