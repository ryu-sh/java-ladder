package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_COUNT_OF_POINTS = 2;

    private final List<Line> lines;

    public Lines(int height, int countOfPoints, LadderGenerateStrategy ladderGenerateStrategy) {
        validateLines(height, countOfPoints);
        lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPoints, ladderGenerateStrategy));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int processLines(int pointIndex) {
        for (Line line : lines) {
            pointIndex = line.movePoint(pointIndex);
        }
        return pointIndex;
    }

    private static void validateLines(int height, int countOfPoints) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + "이상입니다.");
        }

        if (countOfPoints < MIN_COUNT_OF_POINTS) {
            throw new IllegalArgumentException("사다리 게임 최소 유저수 " + MIN_COUNT_OF_POINTS + "이상입니다.");
        }
    }

}