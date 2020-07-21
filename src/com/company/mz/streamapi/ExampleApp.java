package com.company.mz.streamapi;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleApp {

    Stream<String> uniqueWorkerNames(Stream<Organization> organizationStream){
        return organizationStream
                .filter(org -> org.getWorkers().size() >7)
                .map(org -> org.getWorkers())
                .flatMap(Collection::stream)
                .map(worker -> worker.getName())
                .distinct();
    }

    Map<Integer, Organization> getOrganizationMap(List<Organization> organizations){
        return organizations.stream()
                .collect(Collectors.toMap(Organization::getId, organozation -> organozation));
    }

    interface Organization{
        int getId();
        List<Worker> getWorkers();
    }
    interface Worker{
        String getName();

    }
}
