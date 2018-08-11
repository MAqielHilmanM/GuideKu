package guideku.bisfor.guideku.api.model;

public class TransactionModel {
    private String by;
    private Date date;
    private String guide;
    private String place;
    private long points;
    private Price price;
    private String services;
    private Status status;

    public String getBy() {
        return by;
    }

    public Date getDate() {
        return date;
    }

    public String getGuide() {
        return guide;
    }

    public String getPlace() {
        return place;
    }

    public long getPoints() {
        return points;
    }

    public Price getPrice() {
        return price;
    }

    public String getServices() {
        return services;
    }

    public Status getStatus() {
        return status;
    }

    public TransactionModel(String by, Date date, String guide, String place, long points, Price price, String services, Status status) {

        this.by = by;
        this.date = date;
        this.guide = guide;
        this.place = place;
        this.points = points;
        this.price = price;
        this.services = services;
        this.status = status;
    }

    public TransactionModel() {

    }

    public class Date {
        private Date created;
        private Date from;
        private Date modified;
        private Date to;
        private Date deadline;

        public Date getCreated() {
            return created;
        }

        public Date getFrom() {
            return from;
        }

        public Date getModified() {
            return modified;
        }

        public Date getTo() {
            return to;
        }

        public Date getDeadline() {
            return deadline;
        }

        public Date(Date created, Date from, Date modified, Date to, Date deadline) {

            this.created = created;
            this.from = from;
            this.modified = modified;
            this.to = to;
            this.deadline = deadline;
        }

        public Date() {

        }
    }

    public class Price {
        private long discount;
        private long service;
        private long ticket;
        private long ticketFee;
        private long total;

        public long getDiscount() {
            return discount;
        }

        public long getService() {
            return service;
        }

        public long getTicket() {
            return ticket;
        }

        public long getTicketFee() {
            return ticketFee;
        }

        public long getTotal() {
            return total;
        }

        public Price(long discount, long service, long ticket, long ticketFee, long total) {
            this.discount = discount;
            this.service = service;
            this.ticket = ticket;
            this.ticketFee = ticketFee;
            this.total = total;
        }

        public Price() {

        }
    }

    public class Status {
        private boolean isDone;
        private boolean isPayed;

        public Status() {
        }

        public boolean isDone() {
            return isDone;
        }

        public boolean isPayed() {
            return isPayed;
        }

        public Status(boolean isDone, boolean isPayed) {
            this.isDone = isDone;
            this.isPayed = isPayed;
        }
    }
}
