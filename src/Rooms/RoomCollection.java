package Rooms;

import java.io.Serializable;
import java.util.*;

import Items.Item;
import Items.ItemCollection;
import MOBs.MOB;
import MOBs.MOBCollection;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class RoomCollection implements Serializable {
	private List<Room> rooms;

	private MOBCollection mobCollection;
	private ItemCollection itemCollection;

	private Room entrance;
	private Room lawn, murderCastle, farmhouse, basement, secret, woods,
			factory, hospital, dakotaApts, kitchen;
	private Room mansonHouse, jail, policeStation, sorority, dahmerApt,
			cemetery, bank, casino, adventureLand, darkAlley;
	private Room spain, paris, dubai, airport, theStreets, foxHollowFarm,
			cleveland, bigRig, motel, desert;

	public RoomCollection() {
		this.rooms = new ArrayList<Room>();
		itemCollection = new ItemCollection();
		mobCollection = new MOBCollection();

		addDefaultRoomsAndItems();
		setMOBsInRooms();
	}

	private void addDefaultRoomsAndItems() {
		lawn = new SceneRoom(
				"The Lawn",
				"There is no escaping now! The lawn is home-base for all players. You are surrounded by thousands upon "
						+ "thousands of acres of dead grass and trees. Daylight does not exist in this area and anything can happen. There "
						+ "is only one way out. Find the key and enter the Murder Castle. You can stay but your chances of survival are slim "
						+ "to none. Do yourself a favor if you’re on the lawn, leave at once and save yo ass.");
		secret = new SceneRoom(
				"TheBonus Room",
				"Congratulations you have made to the bonus room. There isn't much to this room. The floor is navy blue and the "
						+ "walls are painted white. There is a table to the north of this room which hold a few items for your collection. Take advantage of the unique item "
						+ "that can only be found in this room! There isn't much to do here and it's not a safe zone so leave once you are done.\n");
		woods = new SceneRoom(
				"The Dark Woods",
				"AAAAAOOOOOOWWWWWWWW. Watch out for those deathly predators hidden in the brush. Their eyes glow with a lively flourish that "
						+ "juxtaposes your inevitable fate. There isn’t much to see here since it is dark. Perhaps you’ll find a flashlight hidden amongst the trees. "
						+ "Word of advice… Watch your back!!");
		basement = new SceneRoom(
				"The Basement of the murder castle",
				"Welcome to the deepest trenches of the murder castle. Beware the piles of corpses. That stench isn't just your feet. Besides the eeriness "
						+ "feeling this room gives you there isn’t much within the space enclosed by these nicely painted red walls.There are no windows to light up "
						+ "you path. The floor is a little slippery as well it's better that you don't ask and continue to explore if you please.");
		murderCastle = new SceneRoom(
				"The Murder Castle",
				"Welcome to the cozy home of Sir HH Holmes. There's no need to be afraid. Unless HH comes home. The ‘Castle’ is located 601-603 W. 63rd St. "
						+ "Chicago. It's three stories and a block long. The ground floor contains Dr. Holmes drugstore. The upper two floors consist of 100 windowless "
						+ "rooms with doorways opening to brick walls, oddly angles hallways, and stairways to nowhere. Sir HH only had one thing in mind when he built "
						+ "this place ... to murder.");
		farmhouse = new SceneRoom(
				"The Wisconsin Farmhouse of Horrors",
				"Welcome to Ed Gein's farmhouse. Pay no mind to the human paraphernalia, Ed Gein definitely does not want to "
						+ "scare you away. The house is in pristine shape but a little out dated. I wouldn’t touch anything Ed wouldn’t like that. "
						+ "He should be arriving shortly. If I were you get what you need and leave.");
		factory = new SceneRoom(
				"The Abandoned Factory",
				"Creeeeeaak. Low-hanging pipes and boarded windows haunt this desolate place. Beware of dangerous machinery. Some murders can be made to look like "
						+ "accidents. Spiders aren't the only thing you should be afraid of in this place.");
		motel = new SceneRoom(
				"The Roach Motel",
				"You have found a safe place. This place is pretty dirty. The walls are moldy with odd colored stains. No one can attack you here, so go ahead. "
						+ "Grab a roach filled cot and get some sleep. Just keep your mouth closed.");
		hospital = new SceneRoom(
				"The Save Yo Self Hospital",
				"Got wounds? Need some patching up? You've come to the right place. This hospital is a bit crowded. It's better to do the job yourself "
						+ "if you can. If you can't, make sure you check your doctor's credentials. Or else you'll have a one way ticket to the morgue.");
		dakotaApts = new SceneRoom(
				"The Dakota Apartments",
				"Welcome to northwest corner of 72nd Street and Central Park West in New York City. This place is also "
						+ "known to be the famous murder place of John Lennon. You are currently standing in a vacant apartment but is nicely "
						+ "furnished. The walls are accented with gold and to east of the room is a shiny object go explore if you please.");
		kitchen = new SceneRoom(
				"Hannibal's Kitchen",
				"You're in for a treat. Pull up a chair and prepare to be served the finest finest white meat you'll consume. Make sure you try the ribs. "
						+ "If your not up for a meal just watch your step. There are odd looking things on the floor rather squishy looking. Word of advice don't "
						+ "eat anything Hannibal gives you.");
		mansonHouse = new SceneRoom(
				"The Manson Family Murder House",
				"This is a really nice home but its best that you don’t make yourself comfortable. Some really messed up murders were planned here."
						+ "");
		jail = new SceneRoom(
				"The Dead End Jail",
				"Bars and Stripes. Welcome to jail. This place is a bit small but it does its job. I can't say you are safe here. There may be a murderer or two in the same "
						+ "cell as you. Also you can say goodbye to the items in your backpack they have been taken into custody. You have lost all your items and won't be getting them back "
						+ ":( sorry.");
		policeStation = new SceneRoom(
				"The Police Station",
				"Got a crime to report? Of course you do, you snitch. This is a safe zone so you are safe... for now. There is a front held desk counter right as you enter "
						+ "the station. the the left and right of the counter are seats.");
		sorority = new SceneRoom(
				"Chi Omega Sorority House at FSU",
				"Wild parties, catty drama, and psycho murders. Come for fun, because this is a party you'll "
						+ "never forget. As you can imagine this place is filthy. There are red solo cups everywhere and practically "
						+ "a keg in every room. Watch your step that could be vomit.");
		dahmerApt = new SceneRoom(
				"Jeffrey Dahmer's Apartment",
				"How is it in Milwaukee? I hope Jeffrey hasn’t marked you as his next victim. Last time I heard none of his male "
						+ "confidants made it out in one piece. Do yourself a favor and leave apartment 213 unless you like to clean dishes "
						+ "because this place could use some cleaning up.");
		cemetery = new SceneRoom(
				"Memorial Cemetery",
				"Tombstones and coffins and dead people sleeping. These are a few of my fa-vor-ite things. "
						+ "Pick up a shovel and bury your victims, before someone buries you.");
		bank = new SceneRoom(
				"Kingsfield Bank",
				"Out of money? You've come to the right place. Finance your bribes here. This bank is pretty fancy, "
						+ "so don't try anything snappy with the guards. The are cameras in every corner and floors are made of marble. I wouldn't stare "
						+ "at the vault it may give people the wrong impression.");
		casino = new SceneRoom(
				"Casino Especial",
				"WOW!! This casino is like no other. Slot machines galore, navy blue carpet with a swirly design. Gamble all your problems away!");
		adventureLand = new SceneRoom(
				"Adventure Land Theme Park",
				"Step right up and claim your prize. This is no Disney land. The rides here are for adults only. "
						+ "I recommend you check out Devil's Flight before you reach your final destination. Keep your hands "
						+ "and feet in the ride at all times and don't forget to kiss yo ass goodbye. ");
		darkAlley = new SceneRoom(
				"The Dark Alley",
				"The best place for illegal transactions. But watch out this alley is pretty narrow and might I add dark. Not all sharks live in the ocean.");
		spain = new SceneRoom(
				"Spain",
				"Ole ... Welcome to Spain! Beware of the bulls that roam the street. They pack a punch if you get "
						+ "hit by one. It is best not to stay here unless you want to die.");
		paris = new SceneRoom(
				"Dubai",
				"Finally a place of relaxation. Nothing bad can happen to you here but you cannot stay forever. For now enjoy "
						+ "your million dollar view.");
		dubai = new SceneRoom(
				"Paris",
				"Welcome to Paris! Visit the crypts under the city and get lost in the Louvre. You wish right? Too bad you are restricted to "
						+ "the catacombs which lie right beneath the heart of Paris. This historic labyrinth contains the remains of at least six million "
						+ "Parisians kept at a chilling 14 degrees Celsius. Try not to lean on the wall made of bones");
		airport = new SceneRoom(
				"The International Airport",
				"Need to get away or do some international business? Travel to Paris, Spain, or Dubai! The airport "
						+ "is a safe zone! It's pretty big. You can watch the planes on the strip getting reading to take off.");
		theStreets = new SceneRoom(
				"The Streets of Detroit",
				"These streets are dangerous you probably don't want to roaming around here at night. Watch yo self.");
		foxHollowFarm = new SceneRoom(
				"Chamber Station",
				"This elegant Tudor-style farm house comes four furnished bedrooms, indoor swimming pool, and a riding "
						+ "stable. You have plenty of privacy since it lies on eighteen and half acres of land. Not too shabby right? "
						+ "Just ignore the fact that the remains of 11 men lie scattered around the land.");
		cleveland = new SceneRoom(
				"The Cleveland Strangler's Murder House",
				"You are currently standing in the Cleveland Strangler’s living room. It is here where two bodies were "
						+ "found during the time of the Strangler’s arrest. Don’t worry he won’t be coming for you but someone "
						+ "else could be. There is a couch to the north of the room and a television. The room is pretty empty "
						+ "the Strangler wasn’t too keen on indoor decorating.");
		bigRig = new SceneRoom(
				"Robert Ben Rhodes' Big Rig",
				"This may look like a normal Big Rig, but look closer. You probably don’t want to be in this mobile torture chamber.");
		desert = new SceneRoom(
				"The Deadly Desert",
				"I hope you brought plenty of water. And watch out for those scorpions too.  Stay here too long, and yo ass "
						+ "will suffer death by dehydration.");

		// Set the entrance of the game to be the lawn
		entrance = lawn;

		entrance = lawn;

		// placing adjacent rooms/constructing room layout for game and placing
		// items in rooms
		// 1
		lawn.setNorthRoom(murderCastle);
		lawn.addItem(itemCollection.getItem(14)); // key always needs to be in
													// the lawn to get into
													// murder castle
		lawn.addItem(itemCollection.getItem(9)); // shovel
		// 2 secret room is meant to be a bonus room
		secret.setNorthRoom(factory);
		secret.addItem(itemCollection.getItem(16)); // disguise can only be
													// found in this room
		secret.addItem(itemCollection.getItem(3)); // aidKit
		secret.addItem(itemCollection.getItem(4)); // general energy boost
		secret.addItem(itemCollection.getItem(7)); // gun
		secret.addItem(itemCollection.getItem(15)); // money
		// 3
		woods.setNorthRoom(hospital);
		woods.setEastRoom(basement);
		woods.addItem(itemCollection.getItem(5)); // a plethora of sticks in da
													// woods
		woods.addItem(itemCollection.getItem(12)); // flashlight because it's
													// dark
		// 4
		basement.setNorthRoom(dakotaApts);
		basement.setEastRoom(murderCastle);
		basement.setWestRoom(woods);
		basement.addItem(itemCollection.getItem(13)); // night vision goggles
		basement.addItem(itemCollection.getItem(15)); // money
		// 5
		murderCastle.setNorthRoom(kitchen);
		murderCastle.setEastRoom(farmhouse);
		murderCastle.setSouthRoom(lawn);
		murderCastle.setWestRoom(basement);
		murderCastle.addItem(itemCollection.getItem(0)); // food
		murderCastle.addItem(itemCollection.getItem(1)); // water
		murderCastle.addItem(itemCollection.getItem(6)); // knife
		// 6
		farmhouse.setSouthRoom(murderCastle);
		farmhouse.addItem(itemCollection.getItem(10)); // rope
		farmhouse.addItem(itemCollection.getItem(9)); // shovel
		// 7
		factory.setSouthRoom(secret);
		factory.setEastRoom(motel);
		factory.addItem(itemCollection.getItem(15)); // money
		// 8
		motel.setNorthRoom(jail);
		motel.setEastRoom(hospital);
		motel.setSouthRoom(factory);
		motel.addItem(itemCollection.getItem(4)); // general energy boost
		// 9
		hospital.setNorthRoom(policeStation);
		hospital.setEastRoom(dakotaApts);
		hospital.setSouthRoom(woods);
		hospital.setWestRoom(motel);
		hospital.addItem(itemCollection.getItem(3)); // aidKit
		hospital.addItem(itemCollection.getItem(4)); // general energy boost
		// 10
		dakotaApts.setNorthRoom(sorority);
		dakotaApts.setEastRoom(kitchen);
		dakotaApts.setSouthRoom(basement);
		dakotaApts.setWestRoom(hospital);
		dakotaApts.addItem(itemCollection.getItem(8)); // sword
		// 11
		kitchen.setNorthRoom(dahmerApt);
		kitchen.setEastRoom(mansonHouse);
		kitchen.setSouthRoom(murderCastle);
		kitchen.setWestRoom(dakotaApts);
		kitchen.addItem(itemCollection.getItem(0)); // food
		kitchen.addItem(itemCollection.getItem(1)); // water
		// 12
		mansonHouse.setNorthRoom(cemetery);
		mansonHouse.setSouthRoom(farmhouse);
		mansonHouse.setWestRoom(kitchen);
		mansonHouse.addItem(itemCollection.getItem(11)); // handcuffs
		// 13
		jail.setEastRoom(policeStation);
		jail.setSouthRoom(motel);
		// no items in jail you lose everything when you go to jail
		// 14
		policeStation.setEastRoom(sorority);
		policeStation.setSouthRoom(hospital);
		policeStation.setWestRoom(jail);
		policeStation.addItem(itemCollection.getItem(4)); // general energy
															// boost
		// 15
		sorority.setNorthRoom(bank);
		sorority.setEastRoom(dahmerApt);
		sorority.setSouthRoom(dakotaApts);
		sorority.setWestRoom(policeStation);
		sorority.addItem(itemCollection.getItem(2)); // bandaid
		// 16
		dahmerApt.setNorthRoom(casino);
		dahmerApt.setEastRoom(cemetery);
		dahmerApt.setSouthRoom(mansonHouse);
		dahmerApt.setWestRoom(sorority);
		dahmerApt.addItem(itemCollection.getItem(4)); // general energy boost
		// 17
		cemetery.setNorthRoom(adventureLand);
		cemetery.setSouthRoom(mansonHouse);
		cemetery.setWestRoom(dahmerApt);
		cemetery.addItem(itemCollection.getItem(9)); // shovel
		// 18
		bank.setEastRoom(casino);
		bank.setSouthRoom(sorority);
		bank.addItem(itemCollection.getItem(15)); // money $$$$
		// 19
		casino.setNorthRoom(darkAlley);
		casino.setEastRoom(adventureLand);
		casino.setSouthRoom(dahmerApt);
		casino.setWestRoom(bank);
		casino.addItem(itemCollection.getItem(15)); // money $$$$
		// 20
		adventureLand.setSouthRoom(cemetery);
		adventureLand.setWestRoom(casino);
		// 21
		darkAlley.setNorthRoom(theStreets);
		darkAlley.setSouthRoom(casino);
		// 22
		spain.setNorthRoom(airport);
		// 23
		paris.setEastRoom(airport);
		// 24
		dubai.setSouthRoom(airport);
		dubai.addItem(itemCollection.getItem(15)); // money $$$$
		// 25
		airport.setNorthRoom(dubai);
		airport.setEastRoom(theStreets);
		airport.setSouthRoom(spain);
		airport.setWestRoom(paris);
		// nothing in the airport safe zone.
		// 26
		theStreets.setEastRoom(foxHollowFarm);
		theStreets.setSouthRoom(darkAlley);
		theStreets.setWestRoom(airport);
		theStreets.addItem(itemCollection.getItem(6)); // knife
		theStreets.addItem(itemCollection.getItem(7)); // gun
		theStreets.addItem(itemCollection.getItem(8)); // sword
		// 27
		foxHollowFarm.setNorthRoom(bigRig);
		foxHollowFarm.setEastRoom(cleveland);
		foxHollowFarm.setWestRoom(theStreets);
		foxHollowFarm.addItem(itemCollection.getItem(13)); // night vision
															// goggles
		// 28
		cleveland.setNorthRoom(desert);
		cleveland.setWestRoom(foxHollowFarm);
		cleveland.addItem(itemCollection.getItem(0)); // food
		cleveland.addItem(itemCollection.getItem(1)); // water
		cleveland.addItem(itemCollection.getItem(4)); // general energy boost
		// 29
		bigRig.setEastRoom(desert);
		bigRig.setSouthRoom(foxHollowFarm);
		// no items in doomsville
		// 30
		desert.setSouthRoom(cleveland);
		desert.setWestRoom(bigRig);
		// no items in the desert

		rooms.add(lawn);
		rooms.add(secret);
		rooms.add(woods);
		rooms.add(basement);
		rooms.add(murderCastle);
		rooms.add(farmhouse);
		rooms.add(adventureLand);
		rooms.add(motel);
		rooms.add(hospital);
		rooms.add(dakotaApts);
		rooms.add(kitchen);
		rooms.add(mansonHouse);
		rooms.add(jail);
		rooms.add(policeStation);
		rooms.add(sorority);
		rooms.add(dahmerApt);
		rooms.add(cemetery);
		rooms.add(bank);
		rooms.add(casino);
		rooms.add(adventureLand);
		rooms.add(darkAlley);
		rooms.add(spain);
		rooms.add(paris);
		rooms.add(dubai);
		rooms.add(airport);
		rooms.add(theStreets);
		rooms.add(foxHollowFarm);
		rooms.add(cleveland);
		rooms.add(bigRig);
		rooms.add(desert);
	}

	public void setMOBsInRooms() {
		dahmerApt.addMOB(mobCollection.getMOB(0));
		lawn.addMOB(mobCollection.getMOB(1));
		lawn.addMOB(mobCollection.getMOB(2));
		theStreets.addMOB(mobCollection.getMOB(3));
		spain.addMOB(mobCollection.getMOB(4));
		woods.addMOB(mobCollection.getMOB(5));
		factory.addMOB(mobCollection.getMOB(6));
		farmhouse.addMOB(mobCollection.getMOB(7));
		kitchen.addMOB(mobCollection.getMOB(8));
		murderCastle.addMOB(mobCollection.getMOB(9));
		
		mobCollection.getMOB(0).changeRoom(dahmerApt);
		mobCollection.getMOB(1).changeRoom(lawn);
		mobCollection.getMOB(2).changeRoom(lawn);
		mobCollection.getMOB(3).changeRoom(theStreets);
		mobCollection.getMOB(4).changeRoom(spain);
		mobCollection.getMOB(5).changeRoom(woods);
		mobCollection.getMOB(6).changeRoom(factory);
		mobCollection.getMOB(7).changeRoom(farmhouse);
		mobCollection.getMOB(8).changeRoom(kitchen);
		mobCollection.getMOB(9).changeRoom(murderCastle);
		
	}

	public ItemCollection getItemCollection() {
		return itemCollection;
	}

	public Room getRoomAt(int index) {
		return rooms.get(index);
	}

	public Room getRoomByName(String name) {
		for (Room room : rooms) {
			if (room.getRoomName().equals(name))
				return room;
		}
		return null;
	}

	public void addNewPlayerToRooms(Player player) {
		entrance.addPlayer(player);

		// Make sure that the player is holding a reference
		// to the room it is located in. In this case, that
		// would be the entrance to the game.
		player.setLocation(entrance);
	}

	public MOBCollection getMobCollection() {
		return mobCollection;
	}

}