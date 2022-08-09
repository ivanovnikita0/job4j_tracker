package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
               score += subject.score();
               count++;
            }
        }
        return score / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            rsl.add(new Label(pupil.name(), score / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer score = temp.get(subject.name());
                if (score != null) {
                    score += subject.score();
                } else {
                    score = subject.score();
                }
                temp.put(subject.name(), score);
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            rsl.add(new Label(pupil.name(), score));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                Integer score = temp.get(subject.name());
                if (score != null) {
                    score += subject.score();
                } else {
                    score = subject.score();
                }
                temp.put(subject.name(), score);
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            rsl.add(new Label(entry.getKey(), entry.getValue()));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }
}