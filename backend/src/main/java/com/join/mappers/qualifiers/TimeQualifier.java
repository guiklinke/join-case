package com.join.mappers.qualifiers;

import com.join.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class TimeQualifier {

    @Named("instantToString")
    public String instantToString(Instant date) {
        return DateUtils.instantToString(date);
    }

    @Named("instantToStringDetailed")
    public String instantToStringDetailed(Instant date) {
        return DateUtils.instantToStringDetailed(date);
    }
}
