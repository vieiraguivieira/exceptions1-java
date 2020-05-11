package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// static para que nao seja instanciado um novo SDF para cada novo dado da
	// reservation

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		// calcular diferença entre datas com milissegundos, mais natural do java
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converte milli em dias
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date(); // cria data com horário de agora
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; // critério pra falar que a operação nao deu erro
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}

}
