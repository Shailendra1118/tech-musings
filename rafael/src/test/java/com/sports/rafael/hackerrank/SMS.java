package com.sports.rafael.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SMS {

    @Test
    void testSMSSplit() {
        String message = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus";
        List<String> segments = segments(message);
        //System.out.println(segments);

    }

    private List<String> segments(String message) {
        List<String> res = new ArrayList<>();
        //int fixedMsgLen = 160;
        int msgLen = message.length();
        if (msgLen <= 160) {
            res.add(message);
            return res;
        }
        // msg len > 160
        int totalSegments = msgLen/160;
        if (msgLen%160 > 0) {
            totalSegments++;
        }
        System.out.println("total seg: "+totalSegments);
        int i = 0;
        //int suffixLen = 5;
        int prevIndex = 0, lastIndex = 0;
        String segment;
        while (i < totalSegments-1) {
            lastIndex = prevIndex + 160 - 5;
            if (message.charAt(lastIndex) != ' ') {
                int idx = lastIndex;
                while (message.charAt(idx) != ' ') {
                    idx--;
                }
                lastIndex = idx+1;
            }
            segment = message.substring(prevIndex, lastIndex);
            segment = segment + "("+ (i + 1) +"/"+totalSegments+")";
            System.out.println(segment);
            prevIndex = lastIndex;
            res.add(segment);
            i++;
        }
        //last segment
        segment = message.substring(prevIndex) + "("+(i+1)+"/"+totalSegments+")";
        res.add(segment);
        System.out.println(segment);
        return res;
    }
}
