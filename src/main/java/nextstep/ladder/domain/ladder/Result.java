package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Result {
    private String result;
    private final String DEFAULT_RESULT = "꽝";

    public Result(String result) {
        validate(result);
        this.result = result;
    }

    public Result() {
        result = DEFAULT_RESULT;
    }

    private void validate(String result) {
        if (result == null || "".equals(result)) {
            throw new IllegalArgumentException("결과는 null 또는 빈값을 입력할 수 없습니다.");
        }
    }

    public String getValue() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result) && Objects.equals(DEFAULT_RESULT, result1.DEFAULT_RESULT);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, DEFAULT_RESULT);
    }
}
