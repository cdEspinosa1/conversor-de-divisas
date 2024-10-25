package com.mycompany.conversorModels;

public record Conversion(String base_code,
                         String target_code,
                         String time_last_update_utc,
                         Double conversion_rate,
                         Double conversion_result) {
}
