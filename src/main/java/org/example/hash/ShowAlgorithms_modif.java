package org.example.hash;

import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShowAlgorithms_modif {
    private static final void showHashAlgorithms(Provider prov, Class<?> typeClass) {
        String type = typeClass.getSimpleName();

        List<Service> algos = new ArrayList<>();

        Set<Service> services = prov.getServices();
        for (Service service : services) {
            if (service.getType().equalsIgnoreCase(type)) {
                algos.add(service);
            }
        }

        if (!algos.isEmpty()) {
            System.out.printf(
                    " --- Provider %s, version %s, info: %s --- %n"
                    , prov.getName()
                    , prov.getVersionStr()
                    , prov.getInfo()
            );
            for (Service service : algos) {
                String algo = service.getAlgorithm();
                System.out.printf("Algorithm name: \"%s\"%n", algo);
            }
        }

        // --- find aliases (inefficiently)
        Set<Object> keys = prov.keySet();
        for (Object key : keys) {
            final String prefix = "Alg.Alias." + type + ".";
            if (key.toString().startsWith(prefix)) {
                String value = prov.get(key.toString()).toString();
                System.out.printf(
                        "Alias: \"%s\" -> \"%s\"%n",
                        key.toString().substring(prefix.length()),
                        value
                );
            }
        }
    }

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        System.out.println(providers.length);
        for (Provider provider : providers) {
            //showHashAlgorithms(provider, MessageDigest.class);
            System.out.println(provider.getName() + "; " + provider.getVersionStr() + "; " + provider.getInfo());

            Set<Service> services = provider.getServices();
            System.out.println("  " + services.size());
            for (Service service : services) {
                System.out.println("  " + service.toString());
                /*if (service.getType().equalsIgnoreCase(type)) {
                    algos.add(service);
                }*/
            }
        }
    }
}