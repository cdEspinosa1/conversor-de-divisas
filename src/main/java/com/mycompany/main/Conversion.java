package com.mycompany.main;

import java.util.Date;

public record Conversion(String base_code,
                         String target_code,
                         String time_last_update_utc,
                         String conversion_rate,
                         String conversion_result) {
}
