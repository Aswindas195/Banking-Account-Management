package com.aswinayyappadas.customer;

import java.util.HashMap;
import java.util.List;

public interface ITransactionProvider {
    HashMap<String, List<Double>> getTransactionMap();
}
