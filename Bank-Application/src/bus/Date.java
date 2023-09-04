package bus;

public class Date {
private int day;
private int month;
private int year;

public Date(int Day, int Month, int Year) {
	this.day= Day;
	this.month= Month;
	this.year= Year;
}

public int getDay() {
	if (day>7) {
		return 0;
	}else {
	return day;
	}
}

public void setDay(int day) {
	this.day = day;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

@Override
public String toString() {
	return "Date [Day=" + day + ", Month=" + month + ", Year=" + year + "]";
}


}
