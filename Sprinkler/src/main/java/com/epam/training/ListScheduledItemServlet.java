package com.epam.training;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.sprinkler.domain.ScheduledItem;

@WebServlet("/admin/listSchedule")
public class ListScheduledItemServlet extends HttpServlet {

    private static final String SCHEDULED_ITEMS_PROPERTY_NAME = "scheduledItems";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        @SuppressWarnings("unchecked")
        List<ScheduledItem> itemsList = (List<ScheduledItem>) getServletContext().getAttribute(SCHEDULED_ITEMS_PROPERTY_NAME);
        sb.append("<table border=\"1\">");
        sb.append("<tr>")
            .append("<td>")
            .append("Item id")
            .append("</td><td>")
            .append("Zone id")
            .append("</td><td>")
            .append("From")
            .append("</td><td>")
            .append("To")
            .append("</td><td>")
            .append("Reacurring")
            .append("</td></tr>");
        for (ScheduledItem item : itemsList) {
            sb.append("<tr>")
                .append("<td>")
                .append(item.getId())
                .append("</td><td>")
                .append(item.getZoneId())
                .append("</td><td>")
                .append(format.format(item.getFrom()))
                .append("</td><td>")
                .append(format.format(item.getTo()))
                .append("</td><td>")
                .append(item.isRecurring())
                .append("</td></tr>");
        }
        sb.append("</table>");
        resp.getWriter().write(sb.toString());
    }
}
