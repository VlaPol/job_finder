package by.tms.job_finder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PagingRequestObject {
    private long objectId;
    private int pageSize;
    private int pageNumber;
}
